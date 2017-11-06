package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Theresa Reus, Philipp Steigler, Roman Würtemberger und Jarno Wagner
 */

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	List <Recipe> findAll();
	List <Recipe> findByNameContaining(String name);
	List <Recipe> findByTags_NameContaining(String tag);
	List <Recipe> findByIngredientContaining(String ingredient);
	List <Recipe> findByUserContaining(String user);
}
