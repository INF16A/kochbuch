package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

//import de.dhbw.mosbach.inf16a.kochbuch.ratingservice.Rating;
//import de.dhbw.mosbach.inf16a.kochbuch.ratingservice.RatingRepository;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Recipe;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.RecipeRepository;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.RezeptUser;
import de.dhbw.mosbach.inf16a.kochbuch.userservice.RezeptUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tim Kühnlein
 * @author Adrian Haase
 * @author Adrian Dumke
 */

@RestController
public class RatingController {

    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private RezeptUserRepository userRepository;
    @Autowired
    private RatingRepository ratingRepository;


    @GetMapping(value = "/rating/{recipeID}/{userID}")
    public short ratingForRecipe(@PathVariable(value = "recipeID") long recipeID,@PathVariable(value = "userID") long userID)
    {
        if(ratingRepository.findByRecipeIdAndUserId(recipeID,userID) instanceof Rating)
            return ratingRepository.findByRecipeIdAndUserId(recipeID,userID).getValue();
        else return 0;
    }

    @PostMapping(value = "/rating")
    public Rating updateRating(@RequestBody RatingRequest request)
    {
        RezeptUser u = userRepository.findOne(request.getUserId());
        Recipe r = recipeRepository.findOne(request.getRecipeId());
        return this.ratingRepository.save(new Rating(u,r,request.getValue()));    //Wird überschrieben oder hinzugefügt?
    }

    @GetMapping(value="/rating/{recipeID}/count/up")
    public long countUpVote(@PathVariable(value = "recipeID") long recipeID)
    {
        return ratingRepository.countByRecipeIdAndValue(recipeID,(short)1);
    }

    @GetMapping(value="/rating/{recipeID}/count/down")
    public long countDownVote(@PathVariable(value = "recipeID") long recipeID)
    {
        return ratingRepository.countByRecipeIdAndValue(recipeID,(short)-1);
    }
}
