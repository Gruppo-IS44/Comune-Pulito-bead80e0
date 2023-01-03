package com.project.comunepulito;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
		httpSecurity.csrf()
			.disable()
			.authorizeHttpRequests()
			.requestMatchers("/signup*")
			.permitAll().and()
			.authorizeHttpRequests()
			.requestMatchers("/login*")
			.permitAll().and()
			.authorizeHttpRequests()
			.requestMatchers("/geojson*")
			.permitAll().and()
			.authorizeHttpRequests()
			.requestMatchers("/mappa*")
			.permitAll().and()
			.authorizeHttpRequests()
			.requestMatchers("/segnalazione*")
			.permitAll()
			.anyRequest().authenticated();
		return httpSecurity.build();
	}
}
