package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Theresa Reus, Philipp Steigler, Roman Würtemberger und Jarno Wagner
 * @author Thomas Hörner, Enrico Greßer und Florian Eder
 */

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findAll();

    Recipe save(Recipe recipe);

	List <Recipe> findByNameContaining(String name);
	List <Recipe> findByTags_NameContaining(String tag);
	List <Recipe> findByIngredient_Id(String ingredient);
	List <Recipe> findByUserContaining(String user);
}
