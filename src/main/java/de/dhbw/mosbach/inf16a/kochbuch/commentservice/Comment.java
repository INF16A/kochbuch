package de.dhbw.mosbach.inf16a.kochbuch.commentservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Recipe;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

import javax.persistence.*;

/**
 * @author Alexander Krieg
 * @author Patrick Eichert
 * @author Theresa Reus
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentId", nullable = false)
	private long id;

	@NonNull
	private String text;

	@NonNull
	private Date creationDate;

	@NonNull
	private long userID;

	@JsonIgnore
	@NonNull
	@ManyToOne
	@JoinColumn(name="rezeptId")
	private Recipe recipe;
}