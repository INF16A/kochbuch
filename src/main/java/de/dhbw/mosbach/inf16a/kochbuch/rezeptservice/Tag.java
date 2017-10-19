package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.ArrayList;
import java.util.List;

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
 *
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Tag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NonNull
	private String name;

	public static List<Tag> demo() {
		List<Tag> t = new ArrayList<>();

		for (int i = 0; i < 8; i++) {
			Tag s = new Tag();
			s.name = "blub" + i;
			t.add(s);
		}

		return t;
	}
}
