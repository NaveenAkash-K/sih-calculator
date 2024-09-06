package com.project.sihcalci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.project.sihcalci.repositories")
@ComponentScan({"com.project.sihcalci.query","com.project.sihcalci.mutation","com.project.sihcalci.repositories","com.project.sihcalci.config","com.project.sihcalci.service","com.project.sihcalci.util","com.project.sihcalci.filter"})
@EntityScan("com.project.sihcalci.models")
@SpringBootApplication
public class SihcalciApplication {

	public static void main(String[] args) {
		SpringApplication.run(SihcalciApplication.class, args);
	}

}
