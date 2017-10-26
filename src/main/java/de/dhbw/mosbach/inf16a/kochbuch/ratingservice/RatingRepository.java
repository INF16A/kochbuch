package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Tim Kühnlein
 * @author Adrian Haase
 * @author Adrian Dumke
 */
public interface RatingRepository extends CrudRepository<Rating, Long> {

    Rating findByRecipeIdAndUserId(long recipeID,long userID);

    Long countByRecipeIdAndValue(long recipeid,short ratingvalue);

    /**
     * geht auch ohne query, siehe oben...
     *
     * @Query("SELECT COUNT(r) FROM Rating r WHERE r.recipe.id=?1 AND r.value=?2")
     * Long myCount(long recipeid, short ratingvalue);
     */
}
