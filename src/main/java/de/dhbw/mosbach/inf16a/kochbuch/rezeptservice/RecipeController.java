package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.UserController;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.UserRepository;
import de.dhbw.mosbach.inf16a.kochbuch.ingredientservice.Ingredient;
import de.dhbw.mosbach.inf16a.kochbuch.ingredientservice.IngredientRepository;
import de.dhbw.mosbach.inf16a.kochbuch.ingredientservice.RecipeIngredient;
import de.dhbw.mosbach.inf16a.kochbuch.ingredientservice.RecipeIngredientRepository;
import de.dhbw.mosbach.inf16a.kochbuch.ratingservice.RatingController;
import de.dhbw.mosbach.inf16a.kochbuch.tags.Tag;
import de.dhbw.mosbach.inf16a.kochbuch.tags.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Thomas Hörner
 * @author Theresa Reus
 * @author Enrico Greßer
 * @author Florian Eder
 * @author Patrick Eichert
 * @author Robert Zebec
 */
@RestController
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private PreparationStepRepository preparationStepRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController userController;

    @Autowired
    private RatingController ratingController;

    @CrossOrigin
    @GetMapping(value = "/recipes")
    public List<Recipe> recipe() {
        return recipeRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(value = "/recipe/{id}")
    public Recipe getRecipeById(@PathVariable(value = "id") long id) {
        return recipeRepository.findOne(id);
    }

    @CrossOrigin
    @GetMapping(value = "/recipe/top3Creationdate")
    public List<Recipe> findTop3ByOrderByCreateDateAsc() {
        return recipeRepository.findTop3ByOrderByCreateDateDesc();
    }

    @CrossOrigin
    @GetMapping(value = "/recipe/top3rating")
    public List<Recipe> findTop3BByRating() {
        return recipeRepository.findTop3ByRating(new PageRequest(0, 3));
    }

    @CrossOrigin
    @PostMapping(value = "/recipe/create")
    public Recipe createRecipe(@RequestBody RecipeRequest recipeRequest, @RequestHeader Principal principal) {

        Recipe newRecipe = this.recipeRepository.save(new Recipe());

        newRecipe.setCreateDate(new Date());

        newRecipe.setCreator(userController.getUser(principal));
        newRecipe.setName(recipeRequest.getName());
        newRecipe.setDescription(recipeRequest.getDescription());
        newRecipe.setDifficulty(recipeRequest.getDifficulty());

        //preperation steps && effort
        List<PreperationStep> preperationSteps = new ArrayList<>();
        int effort = 0;
        int stepCount = 0;
        for (PreparationStepRequest step : recipeRequest.getPrepSteps()) {
            effort += step.getEffort();
            PreperationStep p = new PreperationStep();
            p.setDescription(step.getInstruction());
            p.setEffort(step.getEffort());
            p.setStepCount(++stepCount);
            p.setRecipe(newRecipe);
            preperationSteps.add(preparationStepRepository.save(p));
        }
        newRecipe.setEffort(effort);
        newRecipe.setPreSteps(preperationSteps);

        //tags
        List<Tag> tags = new ArrayList<>();
        for (TagRequest tagRequest : recipeRequest.getTags()) {
            Tag tag;
            boolean contains = false;
            //doppelte tags raus
            for (Tag tempTag : tags)
                if (tempTag.getName().equalsIgnoreCase(tagRequest.getName()))
                    contains = true;
            if (!contains) {
                if (tagRequest.getId() >= 0)
                    tag = tagRepository.findOne(tagRequest.getId());
                else {
                    tag = new Tag();
                    tag.setName(tagRequest.getName());
                    tag = tagRepository.save(tag);
                }
                tags.add(tag);
            }
        }
        newRecipe.setTags(tags);

        //pics
        List<Picture> pics = new ArrayList<>();
        for (PictureRequest pictureRequest : recipeRequest.getPics()) {
            Picture p = new Picture();
            p.setPicData(pictureRequest.getPicData());
            p.setPicType(pictureRequest.getPicType());
            pics.add(pictureRepository.save(p));
        }
        newRecipe.setPics(pics);

        //ingredients
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        for (RecipeIngredientRequest ingredientRequest : recipeRequest.getIngredients()) {
            RecipeIngredient recipeIngredient = new RecipeIngredient();

            Ingredient i = ingredientRepository.findOne(ingredientRequest.getIngredientId());

            recipeIngredient.setRecipe(newRecipe);
            recipeIngredient.setIngredient(i);
            recipeIngredient.setAmountPerPerson((int) (ingredientRequest.getAmount() / recipeRequest.getPersons()));
            recipeIngredient.setCostPerUnit(i.getCostPerUnit());

            recipeIngredients.add(recipeIngredientRepository.save(recipeIngredient));
        }
        newRecipe.setRecipeIngredients(recipeIngredients);

        return this.recipeRepository.save(newRecipe);
    }

    @CrossOrigin
    @GetMapping(value = "/recipes/creator/{userID}")
    public List<Recipe> getRecipeByCreator(@PathVariable(value = "userID") long userID) {
        User user = userRepository.findOne((long) userID);
        return recipeRepository.findByCreator(user);
    }
}
