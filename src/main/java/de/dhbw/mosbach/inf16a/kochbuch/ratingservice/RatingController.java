package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

//import de.dhbw.mosbach.inf16a.kochbuch.ratingservice.Rating;
//import de.dhbw.mosbach.inf16a.kochbuch.ratingservice.RatingRepository;
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
    private RatingRepository ratingRepository;

    @GetMapping(value = "/rating/{recipeID}")
    public List<Rating> ratingForRecipe(@PathVariable(value = "recipeID") long recipeID)
    {
        return ratingRepository.findByRecipeId(recipeID);
    }

    @PostMapping(value = "/rate")
    public Rating updateRating(@RequestBody Rating theNewRating)
    {
        return this.ratingRepository.save(theNewRating);    //Wird überschrieben oder hinzugefügt?
    }

    @GetMapping(value="/rating/{recipeID}/count/up")
    public long countUpVote(@PathVariable(value = "recipeID") long recipeID)
    {
        //int i = 1;
        //return ratingRepository.countByRecipeIdByValue(recipeID, i);
        return 1;
    }

    @GetMapping(value="/rating/{recipeID}/count/down")
    public long countDownVote(@PathVariable(value = "recipeID") long recipeID)
    {
        //int i = -1;
        //return ratingRepository.countByRecipeIdByValue(recipeID, i);
        return -1;
    }
}
