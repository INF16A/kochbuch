package de.dhbw.mosbach.inf16a.kochbuch.helloworld;

import lombok.Data;
import lombok.NonNull;

@Data
public class GreetingRequest
{
	@NonNull
	private String name;
	@NonNull
	private String content;
}
