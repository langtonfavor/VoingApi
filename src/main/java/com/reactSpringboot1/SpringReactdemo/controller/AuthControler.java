package com.reactSpringboot1.SpringReactdemo.controller;

import java.net.URI;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.reactSpringboot1.SpringReactdemo.authenticity.ApiResponse;
import com.reactSpringboot1.SpringReactdemo.authenticity.JwtAuthenticationResponse;
import com.reactSpringboot1.SpringReactdemo.authenticity.LoginRequest;
import com.reactSpringboot1.SpringReactdemo.authenticity.SignUpRequest;
import com.reactSpringboot1.SpringReactdemo.modal.Role;
import com.reactSpringboot1.SpringReactdemo.modal.RoleName;
import com.reactSpringboot1.SpringReactdemo.modal.User;
import com.reactSpringboot1.SpringReactdemo.repository.RoleRepository;
import com.reactSpringboot1.SpringReactdemo.repository.UserRepository;
import com.reactSpringboot1.SpringReactdemo.security.JwtTokenProvider;


@RestController
@RequestMapping("/api/auth")
public class AuthControler {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncorder;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	@PostMapping("/signin")
	public ResponseEntity<?>authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		
		Authentication authentication=authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(
							loginRequest.getUsernameOrEmail(),
							loginRequest.getPassword()
		
							));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		String jwt = jwtTokenProvider.generateToken(authentication);
		
		
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
		
	}

	
	@PostMapping("/signup")
	public ResponseEntity<?>registerUser(@Valid @RequestBody SignUpRequest signUprequest){
		if(userRepository.existsByUsername(signUprequest.getUsername())){
			
			return new ResponseEntity(new ApiResponse(false, "username already taken"),
					HttpStatus.BAD_REQUEST);
		}
	if(userRepository.existsByEmail(signUprequest.getEmail())){
		
		
		return new ResponseEntity(new ApiResponse(false, "Email you provided has been taken"),
				HttpStatus.BAD_REQUEST);
		
	}
	
	User user=new User(signUprequest.getName(), signUprequest.getUsername(), signUprequest.getEmail(), signUprequest.getPassword());

	user.setPassword(passwordEncorder.encode(user.getPassword()));
	
	 Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
            //<RuntimeException>orElseThrow .orElseThrow(() -> new AppException("User Role not set."));
			.orElseThrow(RuntimeException::new);	
	
	user.setRoles(Collections.singleton(userRole));
	
	User result = userRepository.save(user);
	
	 URI location = ServletUriComponentsBuilder
             .fromCurrentContextPath().path("/api/users/{username}")
             .buildAndExpand(result.getUsername()).toUri();

	   return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}
}
