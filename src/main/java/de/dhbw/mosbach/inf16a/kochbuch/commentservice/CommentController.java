package de.dhbw.mosbach.inf16a.kochbuch.commentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 💩 Alexander Krieg
 */

@RestController
public class CommentController
{

	@Autowired
	private CommentRepository commentRepository;


	@GetMapping(value = "/comments")
	public List<Comment> comments()
	{
		return commentRepository.findAllByOrderByCreationDateDesc();
	}

	@GetMapping(value = "/comments/{recipeID}")
	public List<Comment> commentsForRecipe(@PathVariable(value = "recipeID") long recipeID)
	{
		return commentRepository.findByRecipeIDOrderByCreationDateDesc(recipeID);
	}

	@PostMapping(value = "/comment")
	public Comment addComment(@RequestBody Comment theNewComment)
	{
		return this.commentRepository.save(theNewComment);
		// return commentRepository.findAllByOrderByCreationDateDesc();
	}

	
}
