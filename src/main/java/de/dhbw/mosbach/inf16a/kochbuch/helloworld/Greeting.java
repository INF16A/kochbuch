package de.dhbw.mosbach.inf16a.kochbuch.helloworld;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Patrick Hahn
 * @author Annika Schatz
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Greeting
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NonNull
	private String name;

	@NonNull
	private String content;
}
