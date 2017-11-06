package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Thomas Hörner
 * @author Enrico Greßer
 * @author Florian Eder
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findAll();

    Recipe save(Recipe recipe);

	List <Recipe> findByNameContaining(String name);

	List <Recipe> findByTags_NameContaining(String tag);

    List<Recipe> findTop3ByOrderByCreateDateDesc();
}
