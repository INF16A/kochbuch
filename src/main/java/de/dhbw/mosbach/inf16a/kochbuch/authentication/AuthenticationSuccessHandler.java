package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
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
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
{
	private final ObjectMapper mapper;

	@Autowired
	private TokenManager tokenManager;

	AuthenticationSuccessHandler(MappingJackson2HttpMessageConverter messageConverter)
	{
		this.mapper = messageConverter.getObjectMapper();
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException
	{
		response.setStatus(HttpServletResponse.SC_OK);

		clearAuthenticationAttributes(request);

		response.addHeader(TokenManager.TOKEN_HEADER, tokenManager.createTokenFrom(authentication));

		KochbuchUserPrincipal principal = (KochbuchUserPrincipal) authentication.getPrincipal();
		PrintWriter writer = response.getWriter();

		mapper.writeValue(writer, principal.getUser());
		writer.flush();
	}
}
