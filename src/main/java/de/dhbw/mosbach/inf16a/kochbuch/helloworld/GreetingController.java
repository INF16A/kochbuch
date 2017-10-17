package de.dhbw.mosbach.inf16a.kochbuch.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Patrick Hahn
 * @author Annika Schatz
 */

@RestController
public class GreetingController
{
	private static final String template = "Hello, %s";

	private final GreetingRepository greetingRepository;

	@Autowired
	public GreetingController(GreetingRepository greetingRepository)
	{
		this.greetingRepository = greetingRepository;
	}

	@GetMapping(value = "/greeting/{name}")
	public List<Greeting> greeting(@PathVariable(value = "name") String name)
	{
		return greetingRepository.findByName(name);
	}

	@PostMapping(value = "/greeting")
	public Greeting greeting(@RequestBody GreetingRequest request)
	{
		return greetingRepository.save(new Greeting(request.getName(), request.getContent()));
	}
}
