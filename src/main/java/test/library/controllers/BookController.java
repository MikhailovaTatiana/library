package test.library.controllers;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import test.library.entities.Book;
import test.library.services.BookService;

import java.util.List;

@Controller
public class BookController {

    private final BookService bookServ;

    public BookController(BookService bookServ) {
        this.bookServ = bookServ;
    }

    @RequestMapping("/all_books")
    public String listBook(@Param("keyword") String keyword, Model model) {
        List<Book> listBooks = bookServ.findAllBooks(keyword);
        model.addAttribute("books", listBooks);
        model.addAttribute("keyword", keyword);
        return "books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") int id, Model model, String keyword) {
        bookServ.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book id:" + id));
        bookServ.deleteBook(id);
        model.addAttribute("books", bookServ.findAllBooks(keyword));
        return "redirect:/all_books";
    }

    @GetMapping("/addBook")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "add_form";
    }

    @PostMapping("/save")
    public String saveBook(@Validated Book book, BindingResult result, Model model, String keyword) {
        if (result.hasErrors()) {
            return "add_form";
        }
        bookServ.saveOrUpdate(book);
        model.addAttribute("books", bookServ.findAllBooks(keyword));
        return "redirect:/all_books";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id, Model model) {
        Book book = bookServ.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book id:" + id));
        model.addAttribute("book", book);
        return "update_form";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") int id, @Validated Book book, BindingResult result, Model model, String keyword) {
        if (result.hasErrors()) {
            book.setId(id);
            return "update_form";
        }
        bookServ.saveOrUpdate(book);
        model.addAttribute("books", bookServ.findAllBooks(keyword));
        return "redirect:/all_books";
    }
}
