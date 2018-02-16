package com.sg.barsonline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { "com.sg.barsonline.dto", "com.sg.barsonline.services",
		"com.sg.barsonline.entities", "com.sg.barsonline.repository", "com.sg.barsonline.controllers" })
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
