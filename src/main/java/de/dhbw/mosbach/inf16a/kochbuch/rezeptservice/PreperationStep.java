package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class PreperationStep {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "preStepId", nullable = false)
	private long id;

	@NonNull
	private int stepCount;

	@NonNull
	private int effort;

	@NonNull
	private String description;

	@NonNull
	@OneToOne
	@JoinColumn(name = "picId")
	private Picture pic;

}
