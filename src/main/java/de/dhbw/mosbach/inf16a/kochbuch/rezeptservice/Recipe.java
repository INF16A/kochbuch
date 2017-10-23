package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import de.dhbw.mosbach.inf16a.kochbuch.Voting.Voting;
import de.dhbw.mosbach.inf16a.kochbuch.commentservice.Comment;
import de.dhbw.mosbach.inf16a.kochbuch.ingredientservice.RecipeIngredient;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Patrick Eichert
 * @author Theresa Reus
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
	private Long id;

	@NonNull
	private String name;

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
	@JoinColumn(name = "picId")
	private List<Picture> pics;

	@NonNull
	@OneToMany(mappedBy = "recipe")
	private List<PreperationStep> preSteps;

	@NonNull
	@OneToMany(mappedBy = "recipe")
	private List<Comment> comments;

	@OneToMany(mappedBy = "recipe")
	private List<RecipeIngredient> recipeIngredients;

	@OneToMany(mappedBy ="recipe")//jedes Rezept kann öfters gevoted werden
	private List<Voting> voting;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Picture> getPics() {
		return pics;
	}

	public void setPics(List<Picture> pics) {
		this.pics = pics;
	}


//	public List<PreperationStep> getPreSteps() {
//		return preSteps;
//	}
//
//	public void setPreSteps(List<PreperationStep> preSteps) {
//		this.preSteps = preSteps;
//	}

//	public List<Comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}

//	public List<RecipeIngredient> getRecipeIngredients() {
//		return recipeIngredients;
//	}
//
//	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
//		this.recipeIngredients = recipeIngredients;
//	}
}
