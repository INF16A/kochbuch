package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import org.springframework.data.repository.CrudRepository;

/**
 * @author André Berberich
 */

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
