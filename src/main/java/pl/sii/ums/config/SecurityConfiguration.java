package pl.sii.ums.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//Konfiguracja skanowania komponentów, oraz autoryzacji i autentykacji.
@Configuration
@EnableWebSecurity
@ComponentScan("pl.sii.ums,"
		+ "pl.sii.ums.entity,"
		+ "pl.sii.ums.controller,"
		+ "pl.sii.ums.services")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { 
	
	//Konfiguracja użytkowników systemu i ich ról
	@Override
	protected void configure (AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("user")
				.password("{noop}password")
				.roles("USER")
				.and()
			.withUser("admin")
				.password("{noop}admin")
				.roles("USER","ADMIN");
	}

	//Konfiguracja http, w celu określenia, dla których URLów wymagana jest autoryzacja, a dla których nie
	@Override
	protected void configure (HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeRequests()
					.antMatchers("/","/home")
						.permitAll()
					.antMatchers("/admin")
						.hasAuthority("ADMIN")
					.anyRequest()
						.authenticated()
					.and()
					.httpBasic();
	}

}
