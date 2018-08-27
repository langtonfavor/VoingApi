package com.reactSpringboot1.SpringReactdemo;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;



@EntityScan(basePackageClasses = { 
		SpringReactdemoApplication.class,
		Jsr310JpaConverters.class 
})

@SpringBootApplication
public class SpringReactdemoApplication {

	@PostConstruct
	void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringReactdemoApplication.class, args);
	}
}
