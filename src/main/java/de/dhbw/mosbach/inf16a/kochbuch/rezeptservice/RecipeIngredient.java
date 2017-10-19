package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Patrick Eichert
 * @author Theresa Reus
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
	private String name;

	@NonNull
	private int amountpp;

	@NonNull
	private int amount;

	@NonNull
	private double costPerUnit;



}
