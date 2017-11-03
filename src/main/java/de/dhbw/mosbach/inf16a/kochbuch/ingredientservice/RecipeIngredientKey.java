package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import java.io.Serializable;

/**
 * @author André Berberich
 */
public class RecipeIngredientKey implements Serializable {
    /**
     * Represents the id of the recipe.
     */
    private Long recipe;
    /**
     * Represents the id of the ingredient.
     */
    private Long ingredient;
}
