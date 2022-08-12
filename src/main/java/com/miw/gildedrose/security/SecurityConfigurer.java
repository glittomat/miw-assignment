package com.miw.gildedrose.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.miw.gildedrose.service.JwtUserDetailsService;


@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		super.configure(auth);
	}
	
	
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		// For h2 console enabling
				 httpSecurity.authorizeRequests().antMatchers("/").permitAll().and()
		         .authorizeRequests().antMatchers("/console/**").permitAll();
				 httpSecurity.csrf().disable();
				 httpSecurity.headers().frameOptions().disable();
				 
//				 
//		httpSecurity.csrf().disable()
//				.authorizeRequests().antMatchers("/authenticate").permitAll().
//				anyRequest().authenticated().and().
//						exceptionHandling().and().sessionManagement()
//				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
//		
//		httpSecurity.csrf().disable()
//		.authorizeRequests().antMatchers("/", "/authenticate").permitAll().and()
//        .authorizeRequests().antMatchers("/console/**").permitAll().
//		anyRequest().authenticated().and().
//				exceptionHandling().and().sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

		
	}

	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	/**
	 * Enabling password encoder.
	 * 
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		 return NoOpPasswordEncoder.getInstance();
//		return  new BCryptPasswordEncoder();
	}

}
 