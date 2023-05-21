package com.koceku.koceku;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// @ComponentScan({ "com.koceku.koceku.Repositories",
// "com.koceku.koceku.Controller", "com.koceku.koceku.Service" })
@SpringBootApplication
// @ComponentScan(basePackages = "com.koceku.koceku")
public class KocekuApplication {

	public static void main(String[] args) {
		SpringApplication.run(KocekuApplication.class, args);
	}

}
