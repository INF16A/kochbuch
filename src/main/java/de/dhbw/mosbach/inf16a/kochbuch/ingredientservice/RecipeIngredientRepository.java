package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Robert Zebec
 */

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Long> {
}
