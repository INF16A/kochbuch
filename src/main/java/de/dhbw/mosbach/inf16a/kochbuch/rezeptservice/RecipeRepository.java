package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Thomas Hörner
 * @author Enrico Greßer
 * @author Florian Eder
 * @author Robert Zebec
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findAll();

    Recipe save(Recipe recipe);

	List <Recipe> findByNameContaining(String name);

	List <Recipe> findByTags_NameContaining(String tag);

    List <Recipe> findTop3ByOrderByCreateDateDesc();

    List <Recipe> findByCreator(User user);
}
