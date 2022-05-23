package io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.rating.service.impl;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.google.common.collect.ImmutableSet;

import org.springframework.stereotype.Service;

import io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.rating.model.Rating;
import io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.rating.service.IRatingService;

@Service
public class RatingService implements IRatingService {

    private final Set<Rating> ratings = new TreeSet<>();

    @Override
    public Rating create(Rating rating) {
        this.validateForCreationAndUpdate(rating);

        var newRating = Rating.builder().id(UUID.randomUUID()).bookId(rating.getBookId()).stars(rating.getStars()).build();
        ratings.add(newRating);

        return newRating;
    }

    @Override
    public Rating update(Rating rating) {
        this.validateForUpdate(rating);

        this.ratings.remove(rating);
        this.ratings.add(rating);

        return rating;
    }

    @Override
    public void delete(Rating rating) {
        this.ratings.remove(rating);
    }

    @Override
    public Set<Rating> findAll() {
        return ImmutableSet.copyOf(this.ratings);
    }

    @Override
    public Optional<Rating> findById(UUID id) {
        if (id == null) {
            return Optional.empty();
        }

        return this.ratings.stream().filter(rating -> id.equals(rating.getId())).findFirst();
    }

    private void validateForCreationAndUpdate(Rating rating) {
        if (rating == null) {
            throw new IllegalArgumentException("Rating can't be null");
        }

        if (rating.getBookId() == null) {
            throw new IllegalArgumentException("Rating can't have a null bookId");
        }
    }

    private void validateForUpdate(Rating rating) {
        this.validateForCreationAndUpdate(rating);

        if (rating.getId() == null) {
            throw new IllegalArgumentException("Can't update a rating without ID");
        }
    }

}
