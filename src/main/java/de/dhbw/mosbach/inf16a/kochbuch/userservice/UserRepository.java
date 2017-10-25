package de.dhbw.mosbach.inf16a.kochbuch.userservice;

import org.springframework.data.repository.CrudRepository;
import de.dhbw.mosbach.inf16a.kochbuch.rezeptservice.User;


/**
 * @author Alexander Krieg
 * 
 */

public interface UserRepository extends CrudRepository<User, Long>
{
}
