package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * @author Thomas Hörner
 * @author Enrico Gresser
 * @author Florian Eder
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RecipeIngredientRequest {

    @NonNull
    private Long ingredientId;

    @NonNull
    private String ingredientName;

    @NonNull
    private Long unitId;

    @NonNull
    private Long amount;

}
