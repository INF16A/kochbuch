package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * 
 * @author Patrick Eichert
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	private String name;

	@NonNull
	private String description;

	@NonNull
	private Integer difficulty;

	@NonNull
	private Date createDate;

//	@NonNull
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(joinColumns = @JoinColumn(name = "recipeId"), inverseJoinColumns = @JoinColumn(name = "tagId"))
//	private List<Tag> tags;

	public void demodata() {
		this.name = "hi";
		this.description = "hides";
		this.difficulty = 5;
		this.createDate = new Date();
//		List<Tag> tagss = Tag.demo();
//		this.tags = tagss;
	}
}
