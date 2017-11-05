package de.dhbw.mosbach.inf16a.kochbuch.rezeptservice;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Thomas Hörner
 * @author Enrico Greßer
 * @author Florian Eder
 */
public interface PictureRepository extends CrudRepository<Picture, Long> {

    Picture save(Picture picture);

}
