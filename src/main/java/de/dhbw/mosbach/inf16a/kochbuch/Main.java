package de.dhbw.mosbach.inf16a.kochbuch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Patrick Hahn
 * @author Annika Schatz
 */

@SpringBootApplication
@EnableOAuth2Sso
public class Main extends WebSecurityConfigurerAdapter {

	public static void main(String[] args)
	{
		SpringApplication.run(Main.class, args);
	}
}
