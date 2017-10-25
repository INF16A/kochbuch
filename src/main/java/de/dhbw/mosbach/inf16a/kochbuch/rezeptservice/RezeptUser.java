package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
public class RezeptUser
{

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
