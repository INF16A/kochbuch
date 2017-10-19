package de.dhbw.mosbach.inf16a.kochbuch.commentservice;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Alexander Krieg
 */

public interface CommentRepository extends CrudRepository<Comment, Long>
{
	List<Comment> findByUserIDOrderByCreationDateDesc(long userID);
//	List<Comment> findByRecipeIDOrderByCreationDateDesc(long recipeID);
	List<Comment> findAllByOrderByCreationDateDesc();
}
