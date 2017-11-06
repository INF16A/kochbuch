package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import de.dhbw.mosbach.inf16a.kochbuch.commentservice.Comment;
import de.dhbw.mosbach.inf16a.kochbuch.ingredientservice.RecipeIngredient;
import de.dhbw.mosbach.inf16a.kochbuch.ratingservice.Rating;
import de.dhbw.mosbach.inf16a.kochbuch.tags.Tag;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Patrick Eichert
 * @author Theresa Reus
 * @author Thomas Hörner
 * @author André Berberich
 * @author Robert Zebec
 * @author Alexander Krieg
 * @author Daniel Abel
 * @author Marc Reinke
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rezeptId", nullable = false)
	private long id;

	@NonNull
	private String name;

	@NonNull
	private Integer effort;

	@NonNull
	private String description;

	@NonNull
	private Integer difficulty;

	@NonNull
	private Date createDate;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "userId")
	private User creator;

	@NonNull
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name = "rezeptId"), inverseJoinColumns = @JoinColumn(name = "tagId"))
	private List<Tag> tags;

	@NonNull
	@OneToMany
	@JoinColumn(name = "recipeId")
	private List<Picture> pics;

	@NonNull
	@OneToMany(mappedBy = "recipe")
	private List<PreperationStep> preSteps;

	@NonNull
	@OneToMany(mappedBy = "recipe")
	private List<Comment> comments;

	@OneToMany(mappedBy = "recipe")
	private List<RecipeIngredient> recipeIngredients;

	@NonNull
	@OneToMany(mappedBy = "recipe")
	private List<Rating> ratings;
}
