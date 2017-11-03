package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	List <Recipe> findAll();
	List <Recipe> findRecipeByNameContains(String keyword);
	List <Recipe> findRecipeByTagsContains(String tag);
}
