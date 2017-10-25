package de.dhbw.mosbach.inf16a.kochbuch.ratingservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.Recipe;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author Tim Kühnlein
 * @author Adrian Haase
 * @author Adrian Dumke
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

    @NonNull
    private short value;    //-1,0,1
}
