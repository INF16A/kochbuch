package de.dhbw.mosbach.inf16a.kochbuch.userservice;

import org.springframework.data.repository.CrudRepository;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.RezeptUser;


/**
 * @author Alexander Krieg
 * 
 */

public interface RezeptUserRepository extends CrudRepository<RezeptUser, Long>
{
}
