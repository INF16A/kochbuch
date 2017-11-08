package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Thomas Hörner
 * @author Enrico Greßer
 * @author Florian Eder
 * @author Theresa Reus
 * @author Daniel Abel
 */
public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findAll();

    Recipe save(Recipe recipe);

	List <Recipe> findByNameContaining(String name);

	List <Recipe> findByTags_NameContaining(String tag);

    List<Recipe> findTop3ByOrderByCreateDateDesc();

    @Query("SELECT re FROM Recipe re, Rating ra where re.id = ra.recipe group by re.id order by sum(ra.value) desc")
    List<Recipe> findTop3ByRating(Pageable pageable);
}
