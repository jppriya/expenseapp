package com.jp.poc.incomeexpense;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class IncomeExpenseApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncomeExpenseApplication.class, args);
	}

}
