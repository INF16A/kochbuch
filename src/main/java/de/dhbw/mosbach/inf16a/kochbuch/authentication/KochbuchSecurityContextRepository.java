package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpRequestResponseHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class KochbuchSecurityContextRepository implements SecurityContextRepository
{
	@Autowired
	private TokenManager tokenManager;

	@Override
	public SecurityContext loadContext(HttpRequestResponseHolder httpRequestResponseHolder)
	{
		SecurityContext context = SecurityContextHolder.createEmptyContext();
		String token = httpRequestResponseHolder.getRequest().getHeader(TokenManager.TOKEN_HEADER);
		if(token == null)
			return context;

		Authentication authentication = tokenManager.createAuthenticationFrom(token);
		if(authentication == null)
			return context;

		context.setAuthentication(authentication);
		return context;
	}

	@Override
	public void saveContext(SecurityContext securityContext, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse)
	{
		if(securityContext.getAuthentication() == null)
			return;
		if(httpServletResponse.getHeader(TokenManager.TOKEN_HEADER) == null) {
			httpServletResponse.addHeader(TokenManager.TOKEN_HEADER, tokenManager.createTokenFrom(securityContext.getAuthentication()));
		}
	}

	@Override
	public boolean containsContext(HttpServletRequest httpServletRequest)
	{
		return false;
	}
}
