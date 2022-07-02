package com.springrest.first;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class FirstApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext cx = SpringApplication.run(FirstApplication.class, args);
		Product p = cx.getBean(Product.class);
		System.out.println(p);
	}

}
