package io.github.maiconfz.usermanager.repository;

import io.github.maiconfz.usermanager.model.User;
import io.github.maiconfz.usermanager.model.UserEmail;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserEmailRepository extends CrudRepository<UserEmail, Long> {
    Optional<UserEmail> findByUser(User user);

    Optional<UserEmail> findByEmail(String email);
}
