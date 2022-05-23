package io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.book.service;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.book.model.Book;

public interface IBookService {
    Book create(Book book);

    Book update(Book book);

    void delete(Book book);

    Set<Book> findAll();

    Optional<Book> findById(UUID id);

}
