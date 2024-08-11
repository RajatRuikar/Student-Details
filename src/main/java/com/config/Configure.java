package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class Configure{

//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//		http
//			.authorizeRequests()
//				.requestMatchers("/**").permitAll()
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("")
//				.permitAll()
//				.and()
//			.logout()
//				.permitAll();
//		return http.build();
//	}

}
