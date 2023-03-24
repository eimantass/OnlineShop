package lt.codeacademy.teamroom4.onlineshop.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static lt.codeacademy.teamroom4.onlineshop.spring.utils.Roles.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/admin/**").hasRole(ADMIN)
			.antMatchers("/customer/**").hasAnyRole(CUSTOMER, ADMIN)
			.antMatchers("/manager/**").hasAnyRole(MANAGER, ADMIN)
			.antMatchers("/serviceManager/**").hasAnyRole(SERVICEMANAGER,ADMIN)
			.antMatchers("/**").permitAll()
		.and()
		.formLogin();
		
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user1 = User
				.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.roles(ADMIN)
				.build();
		UserDetails user2 = User
				.withUsername("customer")
				.password(passwordEncoder().encode("customer"))
				.roles(CUSTOMER)
				.build();
		UserDetails user3 = User
				.withUsername("manager")
				.password(passwordEncoder().encode("manager"))
				.roles(MANAGER)
				.build();
		UserDetails user4 = User
				.withUsername("service")
				.password(passwordEncoder().encode("service"))
				.roles(SERVICEMANAGER)
				.build();
		
		return new InMemoryUserDetailsManager(user1,user2,user3,user4);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}