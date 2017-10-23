package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;



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

	@NonNull
	@OneToOne
	@JoinColumn(name = "picId")
	private Picture pic;

}
