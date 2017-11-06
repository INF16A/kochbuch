package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Thomas Hörner
 */
public interface PreparationStepRepository extends CrudRepository<PreperationStep, Long> {

    PreperationStep save(PreperationStep preperationStep);

}
