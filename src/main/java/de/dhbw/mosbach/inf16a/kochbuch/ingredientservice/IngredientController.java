package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author André Berberich
 */
@RestController
public class IngredientController {

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping(value = "/ingredients")
    public List<Ingredient> ingredients()
    {
        return ingredientRepository.findAll();
    }

    @GetMapping(value="/ingredient/{id}")
    public Ingredient getIngredientById(@PathVariable(value = "id")Long id) {
        return ingredientRepository.findFirstById(id);
    }
}
