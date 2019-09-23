package pl.sii.ums.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter { 
	
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