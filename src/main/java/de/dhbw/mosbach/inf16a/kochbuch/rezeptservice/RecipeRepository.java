package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Thomas Hörner
 * @author Enrico Greßer
 * @author Florian Eder
 * @author Yoco Harrmann
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findAll();

    Recipe save(Recipe recipe);



    /* Yoco Harrmann */
	List <Recipe> findByNameContaining(String name);

	List <Recipe> findByTags_NameContaining(String tag);

    List <Recipe> findByIngredients_NameContaining(String tag);

    // List <Recipe> findByUsernameContaining(String tag);
    /* Ende Yoco */
}
