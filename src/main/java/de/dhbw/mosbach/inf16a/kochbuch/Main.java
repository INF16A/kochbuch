package de.dhbw.mosbach.inf16a.kochbuch;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.savedrequest.NullRequestCache;

/**
 * @author Patrick Hahn
 * @author Annika Schatz
 * @author Armin Beck
 * @author Leandro Späth
 */



@SpringBootApplication
public class Main
{
	public static void main(String[] args)
	{
		SpringApplication.run(Main.class, args);
	}

	@Configuration
	@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
	protected static class SecurityConfiguration extends WebSecurityConfigurerAdapter
	{
		@Autowired
		HttpAuthenticationEntryPoint entryPoint;

		@Autowired
		private AuthenticationProvider authenticationProvider;

		@Autowired
		private AuthenticationSuccessHandler successHandler;

		@Autowired
		private AuthenticationFailedHandler failedHandler;

		@Autowired
		private KochbuchSecurityContextRepository securityContextRepository;

		@Autowired
		private KochbuchLogoutSuccessHandler logoutSuccessHandler;

		@Override
		protected void configure(HttpSecurity http) throws Exception
		{
			http.exceptionHandling()
					.authenticationEntryPoint(entryPoint);

			http.formLogin()
					.loginProcessingUrl("/login")
					.successHandler(successHandler)
					.failureHandler(failedHandler);

			http.logout()
					.logoutUrl("/logout")
					.logoutSuccessHandler(logoutSuccessHandler);

			http.securityContext()
					.securityContextRepository(securityContextRepository);

			http.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

			http.csrf().disable();

			//http.authenticationProvider(authenticationProvider);

			http.requestCache().requestCache(new NullRequestCache());

			http.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/comment").hasRole("USER")
					.antMatchers(HttpMethod.GET, "/auth/user").hasRole("USER")
					.anyRequest().permitAll();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception
		{
			auth.authenticationProvider(authenticationProvider);
		}
	}
}
