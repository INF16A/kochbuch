package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Recipe;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

/**
 * @author Tim Kühnlein
 * @author Adrian Haase
 * @author Adrian Dumke
 */
public interface RatingRepository extends CrudRepository<Rating, Long> {

    List<Rating> findByRecipeId(long recipeID);

    @Query("SELECT COUNT(r) FROM Rating r WHERE r.recipe=?1 AND r.value=?2")
    Long myCount(Recipe r, short s);

    //long countByRecipeIdByValue(long recipeID, int value);

    //List<Rating> findAllByRecipeIDByValue(long recipeID, int value);
    //long count(findByRecipeIDWhereValue=1);
    //int sumfindByRecipeIDvalue();
}
