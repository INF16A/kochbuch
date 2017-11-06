package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Theresa Reus
 * @author Endrit Çallaki
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
	public Recipe getRecipeById(@PathVariable(value="id") long id) {
		return recipeRepository.findOne(id);
	}

	@GetMapping(value = "/recipe/{tag}")
	public List<Recipe> getRecipeByTag(@PathVariable(value="tag") String tag) {	return recipeRepository.findRecipeByTags_nameContaining(tag);
	}

	@GetMapping(value = "/recipe/{keyword}")
	public List<Recipe> getRecipeByKeyword(@PathVariable(value="keyword") String keyword) { return recipeRepository.findRecipeByNameContaining(keyword); }
}
