package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

//import de.dhbw.mosbach.inf16a.kochbuch.ratingservice.Rating;
//import de.dhbw.mosbach.inf16a.kochbuch.ratingservice.RatingRepository;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Recipe;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.RecipeRepository;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.User;
import de.dhbw.mosbach.inf16a.kochbuch.userservice.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    private UserRepository userRepository;
    @Autowired
    private RatingRepository ratingRepository;

    /**
     * Irrelevant
     */
    @GetMapping(value = "/rating/{recipeID}")
    public List<Rating> ratingForRecipe(@PathVariable(value = "recipeID") long recipeID)
    {
        return ratingRepository.findByRecipeId(recipeID);
    }

    @PostMapping(value = "/rating")
    public Rating updateRating(@RequestBody RatingRequest request)
    {
        User u = userRepository.findOne(request.getUserId());
        Recipe r = recipeRepository.findOne(request.getRecipeId());
        return this.ratingRepository.save(new Rating(u,r,request.getValue()));    //Wird überschrieben oder hinzugefügt?
    }

    @GetMapping(value="/rating/{recipeID}/count/up")
    public long countUpVote(@PathVariable(value = "recipeID") long recipeID)
    {
        return ratingRepository.myCount(recipeID,(short)1);
    }

    @GetMapping(value="/rating/{recipeID}/count/down")
    public long countDownVote(@PathVariable(value = "recipeID") long recipeID)
    {
        return ratingRepository.myCount(recipeID,(short)-1);
    }

    /*
    @GetMapping(value="{recipeId}/test/{value}")
    public long myCount(@PathVariable(value ="recipeId") long r,@PathVariable(value = "value") short v)
    {
        return ratingRepository.myCount(r,v);
    }
    */
}
