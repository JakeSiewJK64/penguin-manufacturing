package com.penguin_manufacturing.penguin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class PenguinApplication {

	public static void main(String[] args) {
		SpringApplication.run(PenguinApplication.class, args);
	}
}
