package de.dhbw.mosbach.inf16a.kochbuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
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
		@Override
		protected void configure(HttpSecurity http) throws Exception
		{
			http
					.formLogin()
					.and()
					.authorizeRequests()
					.anyRequest().permitAll();
		}
	}
}
