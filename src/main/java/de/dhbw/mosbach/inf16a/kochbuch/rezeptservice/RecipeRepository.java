package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Thomas Hörner
 * @author Enrico Greßer
 * @author Florian Eder
 * @author Theresa Reus
 * @author Daniel Abel
 * @author Robert Zebec
 * @author Yoco Harrmann, Christian Werner, Georg Frey
 * @author Jarno Wagner, Phlipp Steigler, Roman Würtemberger, Yoco Harrmann
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findAll();

    Recipe save(Recipe recipe);

    List<Recipe> findTop3ByOrderByCreateDateDesc();

    /**
     * Theresa Reus
     * SELECT-Statement um die Rezepte mit den besten Rating herauszufinden, sortiert absteigend nach dem Rezept mit den besten Rating
     */
    @Query("SELECT re FROM Recipe re, Rating ra where re.id = ra.recipe group by re.id order by sum(ra.value) desc")
    List<Recipe> findTop3ByRating(Pageable pageable);

    List<Recipe> findByCreator(User user);

    /* Yoco Harrmann, Christian Werner, Georg Frey */
    List<Recipe> findByNameContainingIgnoreCase(String name);
    List<Recipe> findByTags_NameContainingIgnoreCase(String tag);
    /* Ende Yoco, Christian, Georg */


    /* Jarno Wagner, Phlipp Steigler, Roman Würtemberger, Yoco Harrmann */
    List<Recipe> findByRecipeIngredients_Ingredient_NameContainingIgnoreCase(String ingredient);
    List<Recipe> findByCreator_UsernameIgnoreCase(String username);
    /* Ende Jarno, Philipp, Roman, Yoco */

}
