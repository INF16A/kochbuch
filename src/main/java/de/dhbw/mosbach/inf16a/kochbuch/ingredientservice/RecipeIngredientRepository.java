package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Robert Zebec
 */

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, RecipeIngredientKey> {
    //RecipeIngredient findFirstById(RecipeIngredientKey id);
    List<RecipeIngredient> findAll();
}
