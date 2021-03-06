package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

//import de.dhbw.mosbach.inf16a.kochbuch.ratingservice.Rating;
//import de.dhbw.mosbach.inf16a.kochbuch.ratingservice.RatingRepository;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.UserRepository;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Recipe;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tim Kühnlein
 * @author Adrian Haase
 * @author Adrian Dumke
 * @author Theresa Reus
 * @author Patrick Eichert
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
     * @param recipeID
     * @param userID
     * @return value of Rating given by one user for one recipe as short
     */
    @CrossOrigin
    @GetMapping(value = "/rating/{recipeID}/{userID}")
    public short ratingForRecipe(@PathVariable(value = "recipeID") long recipeID,@PathVariable(value = "userID") long userID)
    {
        if(ratingRepository.findByRecipeIdAndUserId(recipeID,userID) instanceof Rating)
            return ratingRepository.findByRecipeIdAndUserId(recipeID,userID).getValue();
        else return 0;
    }

    /**
     * First deletes all ratings given by a user for one recipe
     * Adds new row in rating table with updated value
     * @param request of type RatingRequest(recipeId, userId, value)
     */
    @CrossOrigin
    @PostMapping(value = "/rating")
    public void updateRating(@RequestBody RatingRequest request)
    {
        User u = userRepository.findOne(request.getUserId());
        Recipe r = recipeRepository.findOne(request.getRecipeId());
        this.ratingRepository.deleteByRecipeIdAndUserId(request.getRecipeId(), request.getUserId());
        this.ratingRepository.save(new Rating(u,r,request.getValue()));
    }

    /**
     * @param recipeID
     * @return amount of upvotes on one recipe as short
     */
    @CrossOrigin
    @GetMapping(value="/rating/{recipeID}/count/up")
    public long countUpVote(@PathVariable(value = "recipeID") long recipeID)
    {
        return ratingRepository.countByRecipeIdAndValue(recipeID,(short)1);
    }

    /**
     * @param recipeID
     * @return amount of downvotes on one recipe as short
     */
    @CrossOrigin
    @GetMapping(value="/rating/{recipeID}/count/down")
    public long countDownVote(@PathVariable(value = "recipeID") long recipeID)
    {
        return ratingRepository.countByRecipeIdAndValue(recipeID,(short)-1);
    }
}
