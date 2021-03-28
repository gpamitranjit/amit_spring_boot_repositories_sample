package com.amit.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.amit.app.repository.jpa"})
public class CustomerJpaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerJpaServiceApplication.class, args);
	}

}
