package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Thomas Hörner
 * @author Enrico Greßer
 * @author Florian Eder
 * @author Yoco Harrmann, Christian Werner, Georg Frey
 * @author Jarno Wagner, Phlipp Steigler, Roman Würtemberger, Yoco Harrmann
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findAll();

    Recipe save(Recipe recipe);

    /* Yoco Harrmann, Christian Werner, Georg Frey */
	List <Recipe> findByNameContaining(String name);
	List <Recipe> findByTags_NameContaining(String tag);
    /* Ende Yoco, Christian, Georg */

    /* Jarno Wagner, Phlipp Steigler, Roman Würtemberger, Yoco Harrmann */
    List <Recipe> findByIngredients_NameContaining(String tag);
    List <Recipe> findByUserContaining(String tag);
    /* Ende Jarno, Philipp, Roman, Yoco */
}
