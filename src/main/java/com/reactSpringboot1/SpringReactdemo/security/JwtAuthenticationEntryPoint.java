package com.reactSpringboot1.SpringReactdemo.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

	private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
	@Override
	public void commence(HttpServletRequest HttpRequest, HttpServletResponse HttpResponse,
			AuthenticationException a) throws IOException, ServletException {
		
		logger.error("respomnding with unauthorized error.Message - {}", a.getMessage() );
		
		HttpResponse.sendError(HttpResponse.SC_UNAUTHORIZED, "you are not authorized to access this page");
		
	}

}
