package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Robert Zebec
 * @author André Berberich
 */

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, RecipeIngredientKey> {
    List<RecipeIngredient> findAllByRecipeId(long recipeId);
    List<RecipeIngredient> findAllByIngredientId(long ingredientId);
    List<RecipeIngredient> findAll();
}
