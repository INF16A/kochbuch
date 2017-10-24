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
 * @author Robert Zebec
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

	@JsonIgnore
	@NonNull
	@Id
	@ManyToOne
	@JoinColumn(name = "ingredientId")
	private Ingredient ingredient;

	/**
	 *  The Transient and PostLoad stuff is used to only include
	 *  the IDs of the referenced entities in the JSON output
	*/

	@Transient
	private Long linkedRecipeId;

	@Transient
	private Long linkedIngredientId;

	@PostLoad
	public void onPostLoad() {
		this.linkedRecipeId = recipe.getId();
		this.linkedIngredientId = ingredient.getId();
	}

	@NonNull
	private Integer amountPerPerson;

	@NonNull
	private Integer amount;

	@NonNull
	private Double costPerUnit;

}
