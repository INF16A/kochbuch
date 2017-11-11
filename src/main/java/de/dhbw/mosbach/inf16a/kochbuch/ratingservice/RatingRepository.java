package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tim Kühnlein
 * @author Adrian Haase
 * @author Adrian Dumke
 */
public interface RatingRepository extends CrudRepository<Rating, Long> {

    Rating findByRecipeIdAndUserId(long recipeID,long userID);

    Long countByRecipeIdAndValue(long recipeid,short ratingvalue);

    @Transactional
    Long deleteByRecipeIdAndUserId(long recipeID,long userID);

    /**
     * First solution for counting
     *
     * @Query("SELECT COUNT(r) FROM Rating r WHERE r.recipe.id=?1 AND r.value=?2")
     * Long myCount(long recipeid, short ratingvalue);
     */
}
