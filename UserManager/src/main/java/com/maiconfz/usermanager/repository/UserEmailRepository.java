package com.maiconfz.usermanager.repository;

import com.maiconfz.usermanager.model.User;
import com.maiconfz.usermanager.model.UserEmail;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserEmailRepository extends CrudRepository<UserEmail, Long> {
    Optional<UserEmail> findByUser(User user);

    Optional<UserEmail> findByEmail(String email);
}
