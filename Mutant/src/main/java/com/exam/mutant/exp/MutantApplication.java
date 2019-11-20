package com.exam.mutant.exp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories("com.exam.mutant.impl")
@ComponentScan("com.exam")
@SpringBootApplication
public class MutantApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MutantApplication.class, args);
	}

}
