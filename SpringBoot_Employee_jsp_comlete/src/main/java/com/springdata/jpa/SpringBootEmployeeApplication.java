package com.springdata.jpa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


/**
 * @author Chirag.Goyal
 *
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
public class SpringBootEmployeeApplication {
	//logging
	static final Logger logger  = LogManager.getLogger(SpringBootEmployeeApplication.class.getName());

	public static void main(String[] args) {
		logger.info("entered application");

		SpringApplication.run(SpringBootEmployeeApplication.class, args);
	}


	/*	//for enabling message.properties file 
	@Bean
	public MessageSource messageSource() {
	    ReloadableResourceBundleMessageSource messageSource
	      = new ReloadableResourceBundleMessageSource();

	    messageSource.setBasename("classpath:messages.properties");
	    messageSource.setDefaultEncoding("UTF-8");
	    return messageSource;
	}*/
}
