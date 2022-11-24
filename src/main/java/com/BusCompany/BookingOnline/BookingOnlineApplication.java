package com.BusCompany.BookingOnline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;


@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class BookingOnlineApplication {

	@Bean
	public LocalValidatorFactoryBean getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		return validator;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookingOnlineApplication.class, args);
	}

}
