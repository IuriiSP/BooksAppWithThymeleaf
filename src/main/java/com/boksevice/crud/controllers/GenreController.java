package com.boksevice.crud.controllers;

import com.boksevice.crud.entities.Genre;
import com.boksevice.crud.repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public String addGenre(@ModelAttribute("genre") @Valid Genre genre, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "genre/new";
        }
        genreRepository.save(genre);
        return "redirect:/genre";
    }

    @GetMapping("/delete/{id}")
    public String deleteGenre(@PathVariable("id") String id, Model model) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid genre Id:" + id));
        genreRepository.delete(genre);
        return "redirect:/genre";
    }
}
