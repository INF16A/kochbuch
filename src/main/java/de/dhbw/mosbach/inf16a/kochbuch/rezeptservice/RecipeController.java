package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Theresa Reus
 */

@RestController
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;

	@GetMapping(value = "/recipes")
	public List<Recipe> recipe() {
		return recipeRepository.findAll();
	}

	@GetMapping(value = "/recipe/{id}")
	public Recipe getRecipeById(Long id) {
		return recipeRepository.findOne(id);
	}

}
