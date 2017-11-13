package de.dhbw.mosbach.inf16a.kochbuch.commentservice;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.*;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.*;
import org.springframework.security.core.Authentication;

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
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserController userController;

    @Autowired
    private TokenManager tokenManager;

    @GetMapping(value = "/comments")
    public List<Comment> comments() {
        return commentRepository.findAllByOrderByCreationDateDesc();
    }

    @GetMapping(value = "/comments/{recipeID}")
    public List<Comment> commentsForRecipe(@PathVariable(value = "recipeID") long recipeID) {
        return commentRepository.findAllByRecipeOrderByCreationDateDesc(recipeRepository.findOne(recipeID));
    }

    @CrossOrigin
    @DeleteMapping(value = "/comment/{commentID}")
    public void deleteComment(@PathVariable(value = "commentID") long commentID, Principal p)
    // public Comment addComment(@RequestBody Comment theNewComment)
    {
        User user = userController.getUser(p);
        Comment comment = commentRepository.findOne(commentID);

        // Recipe re = recipeRepository.findOne(request.getRecipeId());
        // User usr = userRepository.findOne(request.getUserId());
        // Comment c = new Comment(request.getText(), request.getCreationDate(), usr, re);
        if (user.getId() == comment.getUser().getId()) {
            commentRepository.delete(commentID);
        } else {
            System.out.println("User: " + user.getId() + "not authorized to delete comment: " + commentID);
        }
        // return this.commentRepository.save(new Comment(request.getText(), request.getCreationDate(), usr, re));
        // return commentRepository.findAllByOrderByCreationDateDesc();
        // return c;
    }

    @CrossOrigin
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