package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Picture;

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
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NonNull
	@Column(length = 48)
	private String name;

	@NonNull
	private Integer unit;

	@NonNull
	private Double kCalPerUnit;

	@NonNull
	private Double costPerUnit;

	public Long getId() {
		return this.id;
	}
}
