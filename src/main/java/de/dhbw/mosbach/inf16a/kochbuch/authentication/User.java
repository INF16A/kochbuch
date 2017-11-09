package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @author Patrick Hahn
 * @author Armin Beck
 * @author Leandro Späth
 * @author Annika Schatz
 * @author Tobias Bloch
 * @author Irina Eurich
 * @author Endrit Çallaki
 */


@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true)
	@NonNull
	private String username;
	
	private String email;

	@JsonIgnore
	private String password;

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
