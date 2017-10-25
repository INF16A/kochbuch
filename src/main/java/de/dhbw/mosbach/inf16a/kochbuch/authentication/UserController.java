package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Patrick Hahn
 * @author Armin Beck
 * @author Leandro Späth
 */


@RestController("/auth/user")
public class UserController
{
	@GetMapping
	public User getUser(Principal principal)
	{
		return ((KochbuchUserPrincipal)((UsernamePasswordAuthenticationToken)principal).getPrincipal()).getUser();
	}

}
