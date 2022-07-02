package com.springrest.Forth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ForthApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForthApplication.class, args);
	}

}
