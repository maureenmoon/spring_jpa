package com.study.spring.auth;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	AuthenticationFailureHandler authenticationFailureHandler;
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		System.out.println("===========  Filter Chain  =============");
		http.csrf((csrf)-> csrf.disable()) //criss-site request forgery protection
			.cors((cors)->cors.disable()) //cross origin resource sharing
			.authorizeHttpRequests((request)->request
					.requestMatchers("/writeForm","/write").hasRole("ADMIN")
					.requestMatchers("/login").permitAll()
					.anyRequest().permitAll()
					);
		http.formLogin(formLogin -> formLogin
                .loginPage("/login")
                .failureHandler(authenticationFailureHandler)
                .usernameParameter("site_username")
                .passwordParameter("site_password")
                .permitAll()
            );
		http.logout(logout->logout.logoutSuccessUrl("/"));
       
        return http.build();
    	}	
	@Bean
	public UserDetailsService userDetailService(PasswordEncoder passwordEncoder) {
		UserDetails user = User.builder()
				.username("admin")
				.password(passwordEncoder.encode("1234"))
				.roles("ADMIN")
				.build();
		System.out.println("password : " + passwordEncoder.encode("1234"));
		
		return new InMemoryUserDetailsManager(user);
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		
	}
}
