package de.dhbw.mosbach.inf16a.kochbuch.registration;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author Annika Schatz
 * @author Tobias Bloch
 * @author Irina Eurich
 */

@Service
public interface RegistrationRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

	User findByUsername(String username);
}
