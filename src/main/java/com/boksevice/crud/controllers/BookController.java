package com.boksevice.crud.controllers;

import com.boksevice.crud.entities.Author;
import com.boksevice.crud.entities.Book;
import com.boksevice.crud.repo.AuthorRepository;
import com.boksevice.crud.repo.BookRepository;
import com.boksevice.crud.repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/books")
@Controller
public class BookController {
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public BookController(BookRepository bookRepository, GenreRepository genreRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String showBooksPage(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "books/books";
    }

    @GetMapping("/new")
    public String addGenre(Model model){
        model.addAttribute(new Book());
        model.addAttribute("authors", authorRepository.findAll());
        model.addAttribute("genres", genreRepository.findAll());
        return "books/new";
    }

    @PostMapping("/addbook")
    public String addBook(@ModelAttribute("book") Book book){
        bookRepository.save(book);
        return "redirect:/books";
    }

    @PostMapping("/deletebook")
    public String removeBook(Model model){
        model.addAttribute("books", bookRepository.findAll());
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id, Model model){
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookRepository.delete(book);
        return "redirect:/books";
    }
}
