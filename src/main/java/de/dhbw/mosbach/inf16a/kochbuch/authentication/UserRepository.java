package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Patrick Hahn
 * @author Armin Beck
 * @author Leandro Späth
 */

@Service
public interface UserRepository extends JpaRepository<User, Long>
{
	Optional<User> findByUsername(String username);
}
