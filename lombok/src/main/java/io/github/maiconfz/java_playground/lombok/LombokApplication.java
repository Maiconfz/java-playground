package io.github.maiconfz.java_playground.lombok;

import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import io.github.maiconfz.java_playground.lombok.model.base.BaseEntity;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class LombokApplication {

	public static void main(String[] args) {
		SpringApplication.run(LombokApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			log.info("Lombok usage");

			final BaseEntity baseEntity = BaseEntity.builder().id(UUID.randomUUID()).build();

			log.info("baseEntity: ");
			log.info("toString: {}", baseEntity.toString());
			log.info("hashCode: {}", baseEntity.hashCode());
		};
	}

}
