package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @author Patrick Hahn
 * @author Armin Beck
 * @author Leandro Späth
 */


public class KochbuchUserPrincipal implements UserDetails
{
	private final Boolean isAnon;
	private final User user;

	public KochbuchUserPrincipal(User user)
	{
		this.isAnon = false;
		this.user = user;
	}

	public KochbuchUserPrincipal(Boolean isAnon)
	{
		this.isAnon = isAnon;
		this.user = null;
	}

	public User getUser()
	{
		return user;
	}

	@Override
	public boolean isEnabled()
	{
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		if(isAnon) {
			return Collections.singletonList(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
		}
		return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getPassword()
	{
		return user == null ? null : user.getPassword();
	}

	@Override
	public String getUsername()
	{
		return user == null ? null : user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}
}
