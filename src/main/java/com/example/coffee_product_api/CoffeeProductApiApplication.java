package com.example.coffee_product_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class CoffeeProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeProductApiApplication.class, args);

		Dotenv dotenv = Dotenv.load();
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
	}

}
