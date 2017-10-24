package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Patrick Hahn
 * @author Armin Beck
 * @author Leandro Späth
 */

@Component
public class AuthenticationFailedHandler extends SimpleUrlAuthenticationFailureHandler
{
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
	{
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

		PrintWriter writer = response.getWriter();
		writer.write(exception.getMessage());
		writer.flush();
	}
}
