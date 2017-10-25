package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author André Berberich
 */

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    Ingredient findFirstById(long userID);
    List<Ingredient> findAll();
}
