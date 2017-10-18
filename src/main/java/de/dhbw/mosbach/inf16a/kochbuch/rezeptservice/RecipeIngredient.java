package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Thomas Hörner
 * @author Florian Eder
 * @author Enrico Greßer
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class RecipeIngredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NonNull
	private long recipeId;

	@NonNull
	private long ingredientId;

	@NonNull
	private long quantity;

}
