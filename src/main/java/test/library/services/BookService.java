package test.library.services;

import test.library.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAllBooks(String keyword);
    Optional<Book> findById(int id);
    Book saveOrUpdate(Book book);
    void deleteBook(int id);
}
