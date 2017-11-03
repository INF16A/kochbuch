package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author André Berberich
 * @author Thomas Hörner
 */
@RestController
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @CrossOrigin
    @GetMapping(value = "/ingredients")
    public List<Ingredient> ingredients() {
        return ingredientRepository.findAll();
    }

    @CrossOrigin
    @GetMapping(value = "/ingredient/{id}")
    public Ingredient getIngredientById(@PathVariable(value = "id") Long id) {
        return ingredientRepository.findFirstById(id);
    }

    @CrossOrigin
    @PostMapping(value = "/ingredient")
    public Ingredient addIngredient(@RequestBody Ingredient newIngredient) {
        return this.ingredientRepository.save(newIngredient);
    }

    /**
     * @author Thomas Hörner
     */
    @CrossOrigin
    @GetMapping(value = "/ingredient/search")
    public List<IngredientLight> findIngredient(@RequestParam("q") String name) {
        if (name == null || name.isEmpty()) {
            return new ArrayList<IngredientLight>();
        }
        // Daten die zurückgegeben werden reduzieren
        List<IngredientLight> tempIngr = new ArrayList<>();
        for (Ingredient ingredient : ingredientRepository.findByNameContainingIgnoreCase(name)) {
            tempIngr.add(
                    new IngredientLight(ingredient.getId(), ingredient.getUnit(), "testunit", ingredient.getName()));
        }
        return tempIngr;
    }
}
