package de.dhbw.mosbach.inf16a.kochbuch.Voting;

import de.dhbw.mosbach.inf16a.kochbuch.commentservice.Comment;
import de.dhbw.mosbach.inf16a.kochbuch.commentservice.CommentRepository;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Recipe;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by User on 20.10.2017.
 */
public class VotingController {

    @Autowired
    private VotingRepository votingRepository;

    @PostMapping(value = "/voting")
    public Voting addVoting(@RequestBody Voting theNewVoting)
    {
        if(theNewVoting.getRating()==0)
        {
            return this.votingRepository.save(theNewVoting);
        }
    }
}
