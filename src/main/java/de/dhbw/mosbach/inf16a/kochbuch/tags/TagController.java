package de.dhbw.mosbach.inf16a.kochbuch.tags;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Thomas Hörner
 *
 */
@RestController
public class TagController {

	@Autowired
	private TagRepository tagRepository;

	
	@GetMapping(value = "/tag")
	public List<Tag> searchTagByName(@RequestParam("search") String name) {

		return null;
	}

}
