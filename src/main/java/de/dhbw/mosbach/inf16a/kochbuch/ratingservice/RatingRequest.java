package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

import lombok.Data;
import lombok.NonNull;

/**
 * @author Tim Kühnlein
 * @author Adrian Haase
 * @author Adrian Dumke
 */


@Data
public class RatingRequest {

    @NonNull
    private long recipeId;

    @NonNull
    private long userId;

    @NonNull
    private short value;
}
