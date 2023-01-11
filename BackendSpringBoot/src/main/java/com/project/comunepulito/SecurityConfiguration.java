package com.project.comunepulito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;




@Configuration
public class SecurityConfiguration {
	@Autowired
	private UtenteRepository utenteRepository;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
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
			.requestMatchers("/mappaGestore*")
			.permitAll().and()
			.authorizeHttpRequests()
			.requestMatchers("/segnalazione*")
			.permitAll().and()
//			.authorizeHttpRequests()
//			.requestMatchers("/mappa*")
//			.permitAll().and()
			.authorizeHttpRequests()
			.requestMatchers("/convalida*")
			.permitAll().and()
			.authorizeHttpRequests()
			.requestMatchers("/testing*")
			.permitAll()
			.anyRequest().authenticated();
		httpSecurity.authenticationProvider(authenticationProvider());
		httpSecurity.httpBasic();
		return httpSecurity.build();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
}
