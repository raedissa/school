package com.swan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class SchoolApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SchoolApplication.class);
		app.addListeners(new ApplicationPidFileWriter("swan.pid"));
		app.run(args);
	}

}
