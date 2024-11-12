package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class ProyectoeliasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoeliasApplication.class, args);
	}

}