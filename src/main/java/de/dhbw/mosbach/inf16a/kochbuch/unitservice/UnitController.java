package de.dhbw.mosbach.inf16a.kochbuch.unitservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Thomas Hörner
 *
 */
@RestController
public class UnitController {

	@CrossOrigin
	@GetMapping(value = "/units")
	List<Unit> getUnits() {
		List<Unit> units = new ArrayList<>();
		units.add(new Unit("g", "Gramm"));
		units.add(new Unit("kg", "Kilogramm"));
		units.add(new Unit("l", "Liter"));
		units.add(new Unit("ml", "Gramm"));
		return units;
	}

}
