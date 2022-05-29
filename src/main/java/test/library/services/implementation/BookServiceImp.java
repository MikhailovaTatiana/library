package test.library.services.implementation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import test.library.entities.Book;
import test.library.repositories.BookRepository;
import test.library.services.BookService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class BookServiceImp implements BookService {

    private BookRepository repo;

    @Override
    public Book saveOrUpdate(Book book) {
        return repo.save(book);
    }

    @Override
    public void deleteBook(int id) {
        repo.deleteById(id);
    }

    @Override
    public List<Book> findAllBooks(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return (List<Book>) repo.findAll();
    }

    @Override
    public Optional<Book> findById(int id) {
        return repo.findById(id);
    }
}
