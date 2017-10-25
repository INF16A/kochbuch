package de.dhbw.mosbach.inf16a.kochbuch.tags;

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
 * @author Theresa Reus
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tagId", nullable = false)
	private long id;

	@NonNull
	private String name;

}
