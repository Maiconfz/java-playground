package io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.rating.controller;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.rating.model.Rating;
import io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.rating.service.IRatingService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/ratings")
@AllArgsConstructor
@Log
public class RatingController {
    private final IRatingService ratingService;

    @GetMapping
    public Set<Rating> findAll() {
        log.info("Listing all ratings");
        return this.ratingService.findAll();
    }

    @GetMapping
    public Set<Rating> findByBookId(
            @RequestParam(required = false) UUID bookId) {
        if (bookId == null) {
            return ratingService.findAll();
        }
        return ratingService.findByBookId(bookId);
    }

    @GetMapping("/{id}")
    public Optional<Rating> findById(@PathVariable UUID id) {
        return this.ratingService.findById(id);
    }

    @PostMapping
    public Rating create(@RequestBody Rating rating) {
        return this.ratingService.create(rating);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.ratingService.delete(Rating.builder().id(id).build());
    }

    @PutMapping("/{id}")
    public Rating update(@PathVariable UUID id, @RequestBody Rating rating) {
        return this.ratingService.update(rating);
    }

}
