package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Patrick Eichert
 * @author Theresa Reus
 * @author Thomas Hörner
 * @author Daniel Abel
 * @author Alexander Krieg
 * @author Daniel Abel
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "picId", nullable = false)
	private long id;

	@NonNull
	@Column(columnDefinition = "longtext")
	private String picData;

	@NonNull
	private String picType;

}
