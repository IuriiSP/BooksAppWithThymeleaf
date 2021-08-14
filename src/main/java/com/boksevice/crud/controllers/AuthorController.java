package com.boksevice.crud.controllers;

import com.boksevice.crud.entities.Author;
import com.boksevice.crud.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;
    //some changes
    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String showAuthorsPage(Model model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/authors";
    }

    @GetMapping("/new")
    public String newAuthor(@ModelAttribute("author") Author author) {
        return "authors/new";
    }

    @PostMapping("/addauthor")
    public String addAuthor(@ModelAttribute("author") @Valid Author author, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "authors/new";
        }
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") String id, Model model) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + id));
        authorRepository.delete(author);
        return "redirect:/authors";
    }

}
