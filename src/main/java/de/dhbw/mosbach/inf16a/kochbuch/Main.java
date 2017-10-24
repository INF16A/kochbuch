package de.dhbw.mosbach.inf16a.kochbuch;

import de.dhbw.mosbach.inf16a.kochbuch.authentication.AuthenticationFailedHandler;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.AuthenticationSuccessHandler;
import de.dhbw.mosbach.inf16a.kochbuch.authentication.HttpAuthenticationEntryPoint;
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

/**
 * @author Patrick Hahn
 * @author Annika Schatz
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

		@Override
		protected void configure(HttpSecurity http) throws Exception
		{
			http
					.authenticationProvider(authenticationProvider)
					.exceptionHandling().authenticationEntryPoint(entryPoint)
					.and()
					.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.usernameParameter("username")
					.passwordParameter("password")
					.successHandler(successHandler)
					.failureHandler(failedHandler)
					.and()
					.csrf().disable()
					.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/comment").authenticated()
					.anyRequest().permitAll();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception
		{
			auth.authenticationProvider(authenticationProvider);
		}
	}
}
