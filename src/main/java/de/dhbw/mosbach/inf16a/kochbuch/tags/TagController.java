package de.dhbw.mosbach.inf16a.kochbuch.tags;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

/**
 * 
 * @author Thomas Hörner
 *
 */
@RestController
public class TagController {

	@Autowired
	private TagRepository tagRepository;

	@CrossOrigin
	@GetMapping(value = "/tag")
	public List<Tag> searchTagByName(@RequestParam("search") String name) {
		if (name == null || name.length() == 0) {
			return new ArrayList<Tag>();
		}
		return tagRepository.findByNameContainingIgnoreCase(name);
	}

	@GetMapping(value = "/tag/all")
	public List<Tag> getAll() {
		return tagRepository.findAll();
	}

	/**
	 * Erstellt ein neuen Tag anhand des angegebenen Parameters und gibt diesen
	 * zurück. Ist der Tag bereits vorhanden, so wird der vorhandene Tag
	 * zürckgegeben und kein neuer Tag erstellt. Wird kein Parameter übergeben, so
	 * wird nichts zurückgegeben.
	 * 
	 * @param name
	 *            Name des neuen Tags
	 * @return Erstellter Tag
	 * @author Thomas Hörner
	 */
	@PostMapping(value = "tag/create")
	public Tag createTag(@RequestBody String name) {
		if (name == null || name.length() == 0)
			return null;
		Tag tag = tagRepository.findByName(name);
		if (tag == null)
			tag = new Tag(name);
		return tagRepository.save(tag);
	}
}
