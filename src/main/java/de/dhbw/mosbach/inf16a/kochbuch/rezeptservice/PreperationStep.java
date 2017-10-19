package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

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
public class PreperationStep {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "preStepId", nullable = false)
	private long id;

	@NonNull
	private int stepCount;

	@NonNull
	private int effort;

	@NonNull
	private String description;

	@NonNull
	@OneToOne
	@JoinColumn(name = "picId")
	private Picture pic;

	@JsonIgnore
	@NonNull
	@ManyToOne
	@JoinColumn(name="rezeptId")
	private Recipe recipe;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getStepCount() {
		return stepCount;
	}

	public void setStepCount(int stepCount) {
		this.stepCount = stepCount;
	}

	public int getEffort() {
		return effort;
	}

	public void setEffort(int effort) {
		this.effort = effort;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Picture getPic() {
		return pic;
	}

	public void setPic(Picture pic) {
		this.pic = pic;
	}
}
