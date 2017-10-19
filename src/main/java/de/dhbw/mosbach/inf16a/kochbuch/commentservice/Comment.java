package de.dhbw.mosbach.inf16a.kochbuch.commentservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Alexander Krieg
 * @author Patrick Eichert
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

	@NonNull
	private long recipeID;

}
