package de.dhbw.mosbach.inf16a.kochbuch.commentservice;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.*;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.security.Principal;
import java.util.List;

/**
 * @author 💩 Alexander Krieg
 * @author Daniel Abel
 * @author Marc Reinke
 * @author Theresa Reus
 * @author Patrick Eichert
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

	@CrossOrigin
	@DeleteMapping(value = "/comment/{commentID}")
	public boolean deleteComment(@PathVariable(value = "commentID") long commentID, Principal p)
	{
		User user = ((KochbuchUserPrincipal)((UsernamePasswordAuthenticationToken)p).getPrincipal()).getUser();
		Comment comment = commentRepository.findOne(commentID);
		if(comment != null){
			if(user.getUserID() == comment.getUser().getUserID()){
				commentRepository.delete(commentID);
				return true;
			}
			else{
				System.out.println("User: "+user.getUserID()+"not authorized to delete comment: "+commentID);
				return false;
			}
		}
		return false;
	}

	@CrossOrigin
	@PostMapping(value = "/comment")
	public Comment addComment(@RequestBody CommentRequest request)
	{
		Recipe re = recipeRepository.findOne(request.getRecipeId());
		User usr = userRepository.findOne(request.getUserId());
		return this.commentRepository.save(new Comment(request.getText(), request.getCreationDate(), usr, re));

	}


}