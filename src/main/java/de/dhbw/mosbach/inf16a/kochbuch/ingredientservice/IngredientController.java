package de.dhbw.mosbach.inf16a.kochbuch.ingredientservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/ingredient")
    public Ingredient addIngredient(@ModelAttribute Ingredient newIngredient)
    {
        return this.ingredientRepository.save(newIngredient);
    }
}
