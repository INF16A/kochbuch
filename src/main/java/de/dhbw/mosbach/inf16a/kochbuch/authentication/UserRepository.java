package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>
{
	Optional<User> findByUsername(String username);
}
