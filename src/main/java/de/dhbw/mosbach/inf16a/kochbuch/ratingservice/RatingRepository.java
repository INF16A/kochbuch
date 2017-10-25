package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * @author Tim Kühnlein
 * @author Adrian Haase
 * @author Adrian Dumke
 */
public interface RatingRepository extends CrudRepository<Rating, Long> {

    List<Rating> findByRecipeId(long recipeID);

    //long countByRecipeIDByValue(long recipeID, int value);

    //List<Rating> findAllByRecipeIDByValue(long recipeID, int value);
    //long count(findByRecipeIDWhereValue=1);
    //int sumfindByRecipeIDvalue();
}
