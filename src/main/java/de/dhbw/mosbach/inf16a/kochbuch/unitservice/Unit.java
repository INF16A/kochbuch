package de.dhbw.mosbach.inf16a.kochbuch.unitservice;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Thomas Hörner
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Unit {
	
	private long id;
	
	@NonNull
	private String shortText;
	
	@NonNull
	private String longText;
	
}
