package de.dhbw.mosbach.inf16a.kochbuch.tags;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {

	List<Tag> findByNameContainingIgnoreCase(String name);

	List<Tag> findAll();
	
	Tag findByName(String name);
	
	Tag save(Tag tagToSave);

}
