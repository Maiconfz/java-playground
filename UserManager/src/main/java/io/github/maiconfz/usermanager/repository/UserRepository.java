package io.github.maiconfz.usermanager.repository;

import io.github.maiconfz.usermanager.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserName(String userName);
}
