package com.expenses.persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.expenses.persistence.entities")
@EnableJpaRepositories(basePackages = "com.expenses.persistence.repository")
public class ExpensesPersistenceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ExpensesPersistenceApplication.class, args);

	}
}
