package ru.neoflex.mvc.controller;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.mvc.entity.Author;
import ru.neoflex.mvc.exception.NotFoundException;
import ru.neoflex.mvc.repository.AuthorRepository;

import javax.validation.Valid;
import java.util.Optional;

@Log
@Controller
@RequestMapping("/author")
public class AuthorController {

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public String list(ModelMap model) {
        model.addAttribute("authors", authorRepository.findAll());
        return "author/list";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }


    @PostMapping("/add")
    public String add(@Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/add";
        }

        authorRepository.save(author);

        return "redirect:/author/";
    }

    @GetMapping("/{id}")
    public String showAuthor(@PathVariable Long id, ModelMap model) {
        Optional<Author> author = authorRepository.findById(id);

        if (author.isPresent()) {
            model.addAttribute("author", author.get());
            return "author/view";
        } else
            throw new NotFoundException();
    }

    //TODO: make show by name always
    @GetMapping("/view/{name}")
    public String showAuthorByName(@PathVariable String name, ModelMap model) {
        Author author = authorRepository.findByName(name);

        if (null != author) {
            model.addAttribute("author", author);
            return "author/view";
        } else
            throw new NotFoundException();
    }

    @PostMapping("/{id}/delete")
    public String deleteAuthor(@PathVariable Long id) {
        authorRepository.deleteById(id);

        return "redirect:/author/";
    }
}
