package com.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class Configure {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(
						authorizeRequests -> authorizeRequests.requestMatchers("/listofallsubjects").permitAll()
								.anyRequest().authenticated() // All other requests require authentication
				).formLogin(formLogin -> formLogin.loginPage("/login").permitAll() // Allow access to the login page for
																					// everyone
						.successHandler(new SimpleUrlAuthenticationSuccessHandler("/home")) // Redirect after login
																							// success
						.failureHandler(new SimpleUrlAuthenticationFailureHandler("/login?error=true")) // Redirect on
																										// login failure
				).logout(logout -> logout.permitAll() // Allow access to logout for everyone
						.logoutSuccessUrl("/login?logout=true") // Redirect after logout success
				).exceptionHandling(
						exceptionHandling -> exceptionHandling.accessDeniedHandler(new CustomAccessDeniedHandler()) 
			);
		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("user").password(passwordEncoder().encode("password")).roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public class CustomAccessDeniedHandler implements AccessDeniedHandler {
        @Override
        public void handle(HttpServletRequest request, HttpServletResponse response,
                           AccessDeniedException accessDeniedException) throws IOException, ServletException {
            // Log or handle access denied errors
            response.sendRedirect("/access-denied"); // Redirect to a custom access denied page
        }
    }

}
