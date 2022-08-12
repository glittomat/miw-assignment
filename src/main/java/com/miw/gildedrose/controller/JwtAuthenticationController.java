package com.miw.gildedrose.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.miw.gildedrose.GildedRoseApp;
import com.miw.gildedrose.domain.messaging.AuthenticationRequest;
import com.miw.gildedrose.domain.messaging.AuthenticationResponse;
import com.miw.gildedrose.domain.messaging.BaseApiResponse;
import com.miw.gildedrose.service.BaseUserDetailsService;
import com.miw.gildedrose.util.JwtUtil;


@RestController
@EnableWebMvc
public class JwtAuthenticationController {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationController.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private BaseUserDetailsService userDetailsService;


	@PostMapping(value = {"/authenticate"}, produces = {MediaType.APPLICATION_JSON_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE})
//	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<BaseApiResponse> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

		try {
			logger.info("***Inside createAuthenticationToken");
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		catch (Exception e) {
			throw new Exception("Exception occured", e);
		}
		
		System.out.println("check1");
		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		logger.debug("after userDetailsService call ", userDetails);
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
}
