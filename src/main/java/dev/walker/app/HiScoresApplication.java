package dev.walker.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.walker"})
@EntityScan(basePackages = {"dev.walker.entities"})
@EnableJpaRepositories(basePackages = {"dev.walker.repos"})
public class HiScoresApplication {

	public static void main(String[] args) {

		SpringApplication.run(HiScoresApplication.class, args);
	}

}
