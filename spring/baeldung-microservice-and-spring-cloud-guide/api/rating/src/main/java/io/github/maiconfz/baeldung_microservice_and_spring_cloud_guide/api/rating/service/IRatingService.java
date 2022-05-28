package io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.rating.service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.rating.model.Rating;

public interface IRatingService {
    Rating create(Rating rating);

    Rating update(Rating rating);

    void delete(Rating rating);

    Set<Rating> findAll();

    Optional<Rating> findById(UUID id);

    Set<Rating> findByBookId(UUID bookId);

}
