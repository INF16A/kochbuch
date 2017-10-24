package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    // @RequestMapping("/getRecipesbyTag")

    @GetMapping(value = "/recipes/{tag}")
    public List<Recipe> getRecipesByTag(String tag) {
        List hilfsarray = recipeRepository.findAll();    //Alle Rezepte ins Hilfsarray reinspeichern
        Iterator<Recipe> iter = hilfsarray.iterator();   //Alle nichtpassenden Rezepte wieder rauswerfen
        while (iter.hasNext()) {
            Recipe rep = iter.next();
            if(! rep.getTags().contains(tag)){
                hilfsarray.remove(rep);
            }
        }
        return hilfsarray;
    }
}
