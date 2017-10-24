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
/*
	@GetMapping(value = "/recipeIngredient/{id}")
	public RecipeIngredient getRecipeIngredientById(@PathVariable(value = "id") long id) {
		return recipeIngredientRepository.findFirstById(id);
	}
*/
	@GetMapping(value = "/recipeIngredients")
	public List<RecipeIngredient> recipeIngredients()
	{
		return recipeIngredientRepository.findAll();
	}
}
