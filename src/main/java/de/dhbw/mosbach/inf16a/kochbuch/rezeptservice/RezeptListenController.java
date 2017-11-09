package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** @author Team Chrocorg: Christian Werner, Yoco Harrmann und Georg Frey
 *  @author Jarno Wagner, Philipp Steigler, Roman Würtemberger, Yoco Harrmann
 */

/** Anfang Christian Werner, Yoco Harrmann, Georg Frey */
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
    /* Ende Christian, Yoco, Georg */


    /* Anfang Jarno, Philipp, Roman, Yoco */
        @CrossOrigin
        @GetMapping(value = "/recipes/{user}")
        public List<Recipe> getRecipesByUser(String user) {
            return recipeRepository.findByNameContaining(user);
        }

        @CrossOrigin
        @GetMapping(value = "/recipes/{ingredient}")
        public List<Recipe> getRecipesByIngredient(String ingredient) {
            return recipeRepository.findByTags_NameContaining(ingredient);
        }
    /* Ende Jarno, Philipp, Roman, Yoco */
}