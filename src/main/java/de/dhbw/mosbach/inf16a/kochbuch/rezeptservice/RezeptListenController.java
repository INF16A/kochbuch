package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Team Chrocorg: Christian Werner, Yoco Harrmann und Georg Frey
 */


@RestController
public class RezeptListenController {

    @Autowired
    private RecipeRepository recipeRepository;

    @CrossOrigin
    @GetMapping(value = "/recipes/{name}")
    public List<Recipe> getRecipesByName(String name) {
        return recipeRepository.findByNameContaining(name);
    }

    @CrossOrigin
    @GetMapping(value = "/recipes/{tag}")
    public List<Recipe> getRecipesByTag(String tag) {
        return recipeRepository.findByTags_NameContaining(tag);
    }

}