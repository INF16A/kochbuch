package de.dhbw.mosbach.inf16a.kochbuch.commentservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.*;
import de.dhbw.mosbach.inf16a.kochbuch.userservice.UserRepository;

import java.util.List;

/**
 * @author 💩 Alexander Krieg
 */

@RestController
public class CommentController
{

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private RecipeRepository recipeRepository;

	@Autowired
	private UserRepository userRepository;


	@GetMapping(value = "/comments")
	public List<Comment> comments()
	{
		return commentRepository.findAllByOrderByCreationDateDesc();
	}

	@GetMapping(value = "/comments/{recipeID}")
	public List<Comment> commentsForRecipe(@PathVariable(value = "recipeID") long recipeID)
	{
		return commentRepository.findAllByRecipeOrderByCreationDateDesc(recipeRepository.findOne(recipeID));
	}
	// @GetMapping(value = "/comments4u/{userID}")
	// public List<Comment> commentsForUser(@PathVariable(value = "userID") long userID)
	// {
	// 	return commentRepository.findAllByRecipe(recipeRepository.findOne(userID));
	// 	// Recipe r = recipeRepository.findOne(userID);
	// 	// return r.getComments();
	// }

	@PostMapping(value = "/comment")
	public Comment addComment(@RequestBody CommentRequest request)
	// public Comment addComment(@RequestBody Comment theNewComment)
	{
		Recipe re = recipeRepository.findOne(request.getRecipeId());
		User usr = userRepository.findOne(request.getUserId());
		return this.commentRepository.save(new Comment(request.getText(), request.getCreationDate(), usr, re));
		
		// return commentRepository.findAllByOrderByCreationDateDesc();
	}

	
}
