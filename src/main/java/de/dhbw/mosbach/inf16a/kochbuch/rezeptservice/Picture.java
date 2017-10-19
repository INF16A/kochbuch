package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Patrick Eichert
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "picId")
	private long id;

	@NonNull
	private String picData;

//	@OneToOne(mappedBy = "pic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private Ingredient ingredient;
//
//	@OneToOne(mappedBy = "pic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	private PreperationStep preStep;

}
