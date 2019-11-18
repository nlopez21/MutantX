package com.exam.mutant.exp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication (scanBasePackages = "com.exam.mutant")
public class MutantApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MutantApplication.class, args);
	}

}
