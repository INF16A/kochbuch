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

    /**
     * Range: -1 / 0 / 1
     */
    private short value;


    // Without constructor Maven will not build @ RatingController l. 46
    public Rating(User user, Recipe recipe, short value) {
        this.user = user;
        this.recipe = recipe;
        this.value = value;
    }
}
