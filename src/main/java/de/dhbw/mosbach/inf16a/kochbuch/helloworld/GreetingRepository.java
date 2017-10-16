package de.dhbw.mosbach.inf16a.kochbuch.helloworld;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Patrick Hahn
 */

public interface GreetingRepository extends CrudRepository<Greeting, Long>
{
	List<Greeting> findByName(String name);
}
