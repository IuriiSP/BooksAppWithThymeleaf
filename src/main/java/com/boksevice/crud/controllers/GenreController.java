package com.boksevice.crud.controllers;

import com.boksevice.crud.entities.Genre;
import com.boksevice.crud.repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/genre")
@Controller
public class GenreController {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping
    public String showGenresPage(Model model) {
        model.addAttribute("genres", genreRepository.findAll());
        return "genre/genres";
    }

    @GetMapping("/new")
    public String newGenre(@ModelAttribute("genre") Genre genre) {
        return "genre/new";
    }

    @PostMapping("/addgenre")
    public String addGenre(@ModelAttribute("genre") Genre genre) {
        genreRepository.save(genre);
        return "redirect:/genre";
    }
}
