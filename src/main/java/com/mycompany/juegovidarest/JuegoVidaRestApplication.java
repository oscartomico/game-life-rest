package com.mycompany.juegovidarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mycompany.juegovidarest.api")
public class JuegoVidaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuegoVidaRestApplication.class, args);
	}

}
