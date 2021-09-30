package com.maiconfz.usermanager;

import com.maiconfz.usermanager.model.User;
import com.maiconfz.usermanager.model.UserEmail;
import com.maiconfz.usermanager.repository.UserEmailRepository;
import com.maiconfz.usermanager.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@Log4j2
public class AppConfig {

    @Bean
    public CommandLineRunner initUsers(UserRepository userRepository, UserEmailRepository userEmailRepository) {
        return (args) -> {
            var userMaiconfz = new User(null, "maiconfz", "12345", null);
            userMaiconfz = userRepository.save(userMaiconfz);
            log.info("User added {}", userMaiconfz);

            var userMaiconfzEmail = new UserEmail(null, "maiconfz@gmail.com", true, false, userMaiconfz);
            userMaiconfzEmail = userEmailRepository.save(userMaiconfzEmail);
            log.info("Email added {}", userMaiconfzEmail);
        };
    }

}
