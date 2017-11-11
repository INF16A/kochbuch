package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;

/**
 * @author Patrick Hahn
 * @author Armin Beck
 * @author Leandro Späth
 * @author Patrick Eichert
 * @author Theresa Reus
 * @author Thomas Hörner
 * @author Marc Reinke
 */


@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	private Long id;

	@Column(nullable = false, unique = true)
	@NonNull
	private String username;

	@JsonIgnore
	private String password;

	@NonNull
	private Date creationDate;

	@NonNull
	private Date deletionDate;

}
