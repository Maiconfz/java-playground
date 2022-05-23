package io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.book.service.impl;

import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import com.google.common.collect.ImmutableSet;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.book.model.Book;
import io.github.maiconfz.baeldung_microservice_and_spring_cloud_guide.api.book.service.IBookService;

@Service
public class BookService implements IBookService {

    private final Set<Book> books = new TreeSet<>();

    @Override
    public Book create(Book book) {
        this.validateForCreationAndUpdate(book);

        var newBook = Book.builder().id(UUID.randomUUID()).title(book.getTitle()).author(book.getAuthor()).build();
        books.add(newBook);

        return newBook;
    }

    @Override
    public Book update(Book book) {
        this.validateForUpdate(book);

        this.books.remove(book);
        this.books.add(book);

        return book;
    }

    @Override
    public void delete(Book book) {
        this.books.remove(book);
    }

    @Override
    public Set<Book> findAll() {
        return ImmutableSet.copyOf(this.books);
    }

    @Override
    public Optional<Book> findById(UUID id) {
        if (id == null) {
            return Optional.empty();
        }

        return this.books.stream().filter(book -> id.equals(book.getId())).findFirst();
    }

    private void validateForCreationAndUpdate(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book can't be null");
        }

        if (StringUtils.isBlank(book.getTitle())) {
            throw new IllegalArgumentException("Book can't have a empty title");
        }

        if (this.books.stream().anyMatch(b -> book.getTitle().equalsIgnoreCase(b.getTitle()))) {
            throw new IllegalArgumentException(String.format("Book with the given title '%s' already exists", book.getTitle()));
        }
    }

    private void validateForUpdate(Book book) {
        this.validateForCreationAndUpdate(book);

        if (book.getId() == null) {
            throw new IllegalArgumentException("Can't update a book without ID");
        }
    }

}
