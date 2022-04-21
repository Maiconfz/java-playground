package io.github.maiconfz.java_playground.lombok;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import io.github.maiconfz.java_playground.lombok.model.base.BaseEntity;
import io.github.maiconfz.java_playground.lombok.model.base.NamedEntity;
import io.github.maiconfz.java_playground.lombok.model.base.User;
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

			final BaseEntity baseEntity = BaseEntity.builder().id(UUID.randomUUID()).creationDate(LocalDateTime.now()).lastUpdateDate(LocalDateTime.now()).build();

			log.info("## baseEntity");
			log.info("toString: {}", baseEntity.toString());
			log.info("hashCode: {}", baseEntity.hashCode());

			final NamedEntity namedEntity = NamedEntity.builder().id(UUID.randomUUID()).creationDate(LocalDateTime.now()).lastUpdateDate(LocalDateTime.now()).name("NamedEntity").build();
			log.info("## namedEntity");
			log.info("toString: {}", namedEntity.toString());
			log.info("hashCode: {}", namedEntity.hashCode());

			final User user = User.builder().id(UUID.randomUUID()).creationDate(LocalDateTime.now()).lastUpdateDate(LocalDateTime.now()).name("User").username("user").email("user@email.com").password("this is a password").build();
			log.info("## User");
			log.info("toString: {}", user.toString());
			log.info("hashCode: {}", user.hashCode());
		};
	}

}
