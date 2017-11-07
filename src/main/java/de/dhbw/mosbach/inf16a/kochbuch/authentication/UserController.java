package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Patrick Hahn
 * @author Armin Beck
 * @author Leandro Späth
 */


@RestController
public class UserController
{
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/auth/user")
	public User getUser(Principal principal)
	{
		return ((KochbuchUserPrincipal)((UsernamePasswordAuthenticationToken)principal).getPrincipal()).getUser();
	}

	@GetMapping(value = "/user/{id}")
	public User getUserById(@PathVariable(value = "id") long id) {
		return userRepository.findOne(id);
	}

}
