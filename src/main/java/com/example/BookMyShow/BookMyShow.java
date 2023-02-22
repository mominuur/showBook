package com.example.BookMyShow;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition
public class BookMyShow {

	public static void main(String[] args) {
		SpringApplication.run(BookMyShow.class, args);
	}

}
