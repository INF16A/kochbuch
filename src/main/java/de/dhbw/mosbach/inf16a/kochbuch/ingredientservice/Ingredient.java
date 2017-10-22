package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;



import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Picture;
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
    private int unit;

    @NonNull
    private double kCalPerUnit;

    @NonNull
    private double costPerUnit;

	@NonNull
	@OneToOne
	@JoinColumn(name = "picId")
	private Picture pic;
}
