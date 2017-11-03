package de.dhbw.mosbach.inf16a.kochbuch.authentication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
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
		System.out.println(authentication.getPrincipal());
		if(authentication instanceof AnonymousAuthenticationToken) {
			return Jwts.builder().claim("anon", true).compact();
		}
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

		Claims claims = Jwts.parser().setSigningKey(jwtKey).parseClaimsJws(token).getBody();
		if(claims.getSubject() != null) {
			Optional<User> user = userRepository.findByUsername(claims.getSubject());
			if(user.isPresent()) {
				KochbuchUserPrincipal principal = new KochbuchUserPrincipal(user.get());
				return new UsernamePasswordAuthenticationToken(principal, "", Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
			}
		} else if(claims.get("anon", Boolean.class)) {
			return  new AnonymousAuthenticationToken("anon", new KochbuchUserPrincipal(true), Collections.singletonList(new SimpleGrantedAuthority("ROLE_ANONYMOUS")));
		}

		return null;
	}
}
