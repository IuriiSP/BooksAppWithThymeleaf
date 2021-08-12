package com.boksevice.crud.controllers;

import com.boksevice.crud.entities.Author;
import com.boksevice.crud.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String showAuthorsPage(Model model){
        model.addAttribute("authors", authorRepository.findAll());
        return "authors/authors";
    }

    @GetMapping("/new")
    public String newAuthor(@ModelAttribute("author") Author author){
        return "authors/new";
    }

    @PostMapping("/addauthor")
    public String addAuthor(@ModelAttribute("author") Author author){
        authorRepository.save(author);
        return "redirect:/authors";
    }

}
