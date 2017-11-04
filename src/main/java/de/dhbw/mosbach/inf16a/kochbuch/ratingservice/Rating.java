package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Recipe;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @author Tim Kühnlein
 * @author Adrian Haase
 * @author Adrian Dumke
 * @author Theresa Reus
 * @author Patrick Eichert
 */

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ratingId", nullable = false)
    private long id;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @JsonIgnore
    @NonNull
    @ManyToOne
    @JoinColumn(name = "rezeptId")
    private Recipe recipe;

    private short value;    //-1,Null,1

    //sonst läuft maven nicht durch s. RatingController l 44
    public Rating(User u, Recipe r, short value)
    {
        this.user = u;
        this.recipe = r;
        this.value = value;
    }
}
