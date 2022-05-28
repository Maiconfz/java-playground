package io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.book.controller;

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
import org.springframework.web.bind.annotation.RestController;

import io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.book.model.Book;
import io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.book.service.IBookService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
@Log
public class BookController {
    private final IBookService bookService;

    @GetMapping
    public Set<Book> findAll() {
        log.info("Listing all books");
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Book> findById(@PathVariable UUID id) {
        return this.bookService.findById(id);
    }

    @PostMapping
    public Book create(@RequestBody Book book) {
        return this.bookService.create(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        this.bookService.delete(Book.builder().id(id).build());
    }

    @PutMapping("/{id}")
    public Book update(@PathVariable UUID id, @RequestBody Book book) {
        return this.bookService.update(book);
    }

}
