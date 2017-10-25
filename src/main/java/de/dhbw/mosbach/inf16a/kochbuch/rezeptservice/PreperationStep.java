package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Patrick Eichert
 * @author Theresa Reus
 * @author Thomas Hörner
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
	private Integer stepCount;

	@NonNull
	private Integer effort;

	@NonNull
	private String description;

	@NonNull
	@OneToOne
	@JoinColumn(name = "picId")
	private Picture pic;

	@JsonIgnore
	@NonNull
	@ManyToOne
	@JoinColumn(name = "rezeptId")
	private Recipe recipe;

}
