package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Robert Zebec
 */

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Long> {
    RecipeIngredient findFirstById(long id);
    List<RecipeIngredient> findAll();
}
