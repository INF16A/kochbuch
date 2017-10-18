package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NonNull
	private String name;

	@NonNull
	private String description;

	@NonNull
	private int difficulty;

	@NonNull
	private Date createDate;

}
