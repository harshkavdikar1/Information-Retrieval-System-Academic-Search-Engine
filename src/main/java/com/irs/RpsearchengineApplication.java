package com.irs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.irs")
public class RpsearchengineApplication {

	public static void main(String[] args) {
		SpringApplication.run(RpsearchengineApplication.class, args);
	}

}
