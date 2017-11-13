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
 * @author Annika Schatz
 * @author Irina Eurich
 * @author Endrit Çallaki
 * @author Tobias Bloch
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

	private String email;

	@NonNull
	private Date creationDate;

	@NonNull
	private Date deletionDate;

	public Long getUserID(){
		return id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
