package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;

/**
 * @author Patrick Hahn
 * @author Armin Beck
 * @author Leandro Späth
 */


@Component
public class TokenManager
{
	@Value("${kochbuch.authentication.jwt.key}")
	private String jwtKey;

	public static final String TOKEN_HEADER = "X-Token";

	@Autowired
	private UserRepository userRepository;

	public String createTokenFrom(Authentication authentication)
	{
		KochbuchUserPrincipal principal = (KochbuchUserPrincipal) authentication.getPrincipal();
		String username = principal.getUsername();
		return Jwts.builder()
				.setSubject(username)
				.setIssuer("INF16A Kochbuch")
				.setNotBefore(new Date())
				.setIssuedAt(new Date())
				.setExpiration(
						Date.from(
								LocalDateTime
										.now()
										.plusDays(1)
										.toInstant(ZoneOffset.ofHours(0))
						)
				)
				.signWith(SignatureAlgorithm.HS256, jwtKey)
				.compact();
	}

	public Authentication createAuthenticationFrom(String token)
	{
		if(token == null || token.isEmpty())
		{
			return null;
		}

		String username = Jwts.parser().setSigningKey(jwtKey).parseClaimsJws(token).getBody().getSubject();

		Optional<User> user = userRepository.findByUsername(username);
		if(user.isPresent()) {
			KochbuchUserPrincipal principal = new KochbuchUserPrincipal(user.get());
			return new UsernamePasswordAuthenticationToken(principal, "", null);
		}
		return null;
	}
}
