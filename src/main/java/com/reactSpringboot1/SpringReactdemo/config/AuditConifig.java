package com.reactSpringboot1.SpringReactdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class AuditConifig {

	@Bean
	public AuditorAware<Long>auditProvider() {
		
		return new SpringAuditAwareImpl();
	}
}


