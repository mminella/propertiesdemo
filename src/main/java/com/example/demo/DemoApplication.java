package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("application_config.xml")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Domain javaBean(@Value("${foo_bar}") String property) {
		Domain domain = new Domain();
		domain.setProperty(property);
		return domain;
	}

	@Bean
	public CommandLineRunner commandLineRunner(Domain javaBean, Domain xmlBean) {
		return strings -> {
			System.out.println("javaBean = " + javaBean.getProperty());
			System.out.println("xmlBean = " + xmlBean.getProperty());
		};
	}
}
