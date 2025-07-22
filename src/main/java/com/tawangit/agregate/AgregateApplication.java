package com.tawangit.agregate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class AgregateApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgregateApplication.class, args);
	}

}
