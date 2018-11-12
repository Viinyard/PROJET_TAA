package pro.vinyard.project.rest.config;

import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author VinYarD
 * created : 13/03/2018, 13:23
 */

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements ApplicationContextAware {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/").permitAll()
				.anyRequest().authenticated()
			.and()
				.formLogin()
				.loginPage("/login")
				.usernameParameter("username")
				.passwordParameter("password")
				.loginProcessingUrl("/login")
				.successForwardUrl("/addresses")
				.failureUrl("/")
			.and()
				.logout()
				.permitAll()
			.and()
				.csrf().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance())
				.withUser("user").password("password").roles("USER").and()
				.withUser("admin").password("password").roles("ADMIN").roles("USER");
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		final User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
		UserDetails user = userBuilder
				.username("user")
				.password("password")
				.roles("USER")
				.build();
		
		UserDetails admin = userBuilder
				.username("admin")
				.password("password")
				.roles("ADMIN","USER")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}
	
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean()
			throws Exception {
		return super.authenticationManagerBean();
	}
}