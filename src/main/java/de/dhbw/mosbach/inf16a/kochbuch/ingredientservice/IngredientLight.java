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
public class IngredientLight {

	@NonNull
	private String name;

	@NonNull
	private String unitName;
	
	@NonNull
	private Integer unitId;
	
}
