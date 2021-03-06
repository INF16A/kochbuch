package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Thomas Hörner
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class IngredientSmall {

	@NonNull
	private Long unitId;

	@NonNull
	private Long ingredientId;

	@NonNull
	private String ingredientName;

}
