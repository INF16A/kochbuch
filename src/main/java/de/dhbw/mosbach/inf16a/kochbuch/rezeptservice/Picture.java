package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Picture {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "picId")
	private long id;

	@NonNull
	private String picData;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPicData() {
		return picData;
	}

	public void setPicData(String picData) {
		this.picData = picData;
	}
}
