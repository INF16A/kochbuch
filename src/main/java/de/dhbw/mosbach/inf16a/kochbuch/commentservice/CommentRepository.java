package de.dhbw.mosbach.inf16a.kochbuch.commentservice;

import org.springframework.data.repository.CrudRepository;

import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Recipe;

import java.util.List;

/**
 * @author Alexander Krieg
 * @author Daniel Abel
 */

public interface CommentRepository extends CrudRepository<Comment, Long>
{
	// List<Comment> findByUserIdOrderByCreationDateDesc(long userID);
//	List<Comment> findByRecipeIDOrderByCreationDateDesc(long recipeID);
	List<Comment> findAllByOrderByCreationDateDesc();
	List<Comment> findAllByRecipe(Recipe r);
	List<Comment> findAllByRecipeOrderByCreationDateDesc(Recipe r);
}
