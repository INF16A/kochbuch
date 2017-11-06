package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author Thomas Hörner
 * @author Enrico Gresser
 * @author Florian Eder
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RecipeRequest {

    @NonNull
    private String name;

    @NonNull
    private String description;

    @NonNull
    private Integer difficulty;

    @NonNull
    private Integer persons;

    @NonNull
    private List<TagRequest> tags;

    @NonNull
    private List<PictureRequest> pics;

    @NonNull
    private List<PreparationStepRequest> prepSteps;

    @NonNull
    private List<RecipeIngredientRequest> ingredients;

}
