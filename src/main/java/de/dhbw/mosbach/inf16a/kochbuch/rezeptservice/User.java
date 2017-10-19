package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.Date;

import javax.persistence.Column;
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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private long id;

	@NonNull
	private String email;

	@NonNull
	private String pwHash;

	@NonNull
	private Date creationDate;

	@NonNull
	private Date deletionDate;

}
