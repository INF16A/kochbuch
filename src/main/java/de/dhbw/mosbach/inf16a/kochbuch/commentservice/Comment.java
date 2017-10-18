package de.dhbw.mosbach.inf16a.kochbuch.commentservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



/**
 * @author Alexander Krieg
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Comment
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
