package de.dhbw.mosbach.inf16a.kochbuch.Voting;

import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

/**
 * Created by User on 20.10.2017.
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Voting {

    private int rating;

    @NonNull
    private long votingID;

    @NonNull
    private User voter;

    @NonNull
    private String bewertung;

    public int getRating()
    {
        return rating;
    }

    public String getBewertung()
    {
        return bewertung;
    }

    public User getVoter()
    {
        return voter;
    }

    public long getVotingID()
    {
        return votingID;
    }



}
