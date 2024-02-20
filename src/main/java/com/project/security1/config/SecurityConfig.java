package com.project.security1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity //스프링 시큐리티 필터가 스프링 필터체인에 등록
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
  
  @Bean
  public BCryptPasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests(auth->auth
			    .requestMatchers("/","/login","/user").permitAll()
			    .requestMatchers("/admin").hasRole("ADMIN")
			    .requestMatchers("/manger").hasAnyRole("ADMIN","MANAGER")
			    .anyRequest().authenticated()
			)
			.formLogin(login->login
					.loginPage("/login")
					.loginProcessingUrl("/loginProc")
					.permitAll()
					.defaultSuccessUrl("/user", true)
					.failureUrl("/error")
			)
			.csrf(csrf->csrf
			    .disable()
			);
			
			
		return http.build();
	}
	
}
