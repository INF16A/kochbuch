package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Robert Zebec
 * @author André Berberich
 */
@RestController
public class RecipeIngredientController {
	@Autowired
    private RecipeIngredientRepository recipeIngredientRepository;

	@GetMapping(value = "/recipeIngredient/recipe/{recipeId}")
	public List<RecipeIngredient> getRecipeIngredientsByRecipeId(@PathVariable(value = "recipeId") long recipeId) {
		return recipeIngredientRepository.findAllByRecipeId(recipeId);
	}

	@GetMapping(value = "/recipeIngredient/ingredient/{ingredientId}")
	public List<RecipeIngredient> getRecipeIngredientsByIngredientId(@PathVariable(value = "ingredientId") long ingredientId) {
		return recipeIngredientRepository.findAllByIngredientId(ingredientId);
	}

	@GetMapping(value = "/recipeIngredients")
	public List<RecipeIngredient> recipeIngredients()
	{
		return recipeIngredientRepository.findAll();
	}
}
