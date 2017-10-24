package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Recipe;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Patrick Eichert
 * @author Theresa Reus
 * @author André Berberich
 * @author Thomas Hörner
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@IdClass(RecipeIngredientKey.class)
@Entity
public class RecipeIngredient {

	@JsonIgnore
	@Id
	@NonNull
	@ManyToOne
	@JoinColumn(name = "recipeId")
	private Recipe recipe;

	@NonNull
	@Id
	@ManyToOne
	@JoinColumn(name = "ingredientId")
	private Ingredient ingredient;

	@NonNull
	private Integer amountPerPerson;

	@NonNull
	private Integer amount;

	@NonNull
	private Double costPerUnit;

}
