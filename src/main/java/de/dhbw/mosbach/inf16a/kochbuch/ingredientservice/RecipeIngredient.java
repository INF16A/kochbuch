package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Ingredient;
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
@Entity
public class RecipeIngredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonIgnore
	@NonNull
	@ManyToOne
	@JoinColumn(name = "recipeId")
	private Recipe recipe;

	@NonNull
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
