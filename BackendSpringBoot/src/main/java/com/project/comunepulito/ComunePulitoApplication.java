package com.project.comunepulito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ComunePulitoApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ComunePulitoApplication.class);
		application.run(args);
	}
}
