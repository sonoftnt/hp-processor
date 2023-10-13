package com.tnt.hp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HpApplication {

	public static void main(String[] args) {
		SpringApplication.run(HpApplication.class, args);
	}
}
