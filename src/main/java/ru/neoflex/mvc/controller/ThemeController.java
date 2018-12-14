package ru.neoflex.mvc.controller;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.mvc.entity.Author;
import ru.neoflex.mvc.entity.Theme;
import ru.neoflex.mvc.exception.NotFoundException;
import ru.neoflex.mvc.repository.ThemeRepository;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/theme")
public class ThemeController {
    private ThemeRepository themeRepository;

    public ThemeController(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @GetMapping
    public String list(ModelMap model) {
        //Sort.Order sortOrder = new Sort.Order(Sort.Direction.ASC, "title");
        //model.addAttribute("themes", themeRepository.findAll(Sort.by(sortOrder)));

        model.addAttribute("themes", themeRepository.findByIdBetween((long)2, (long)4));
        return "theme/list";
    }

    @GetMapping("/add")
    public String add(ModelMap model) {
        model.addAttribute("theme", new Theme());
        return "theme/add";
    }


    @PostMapping("/add")
    public String add(@Valid Theme theme, BindingResult result) {
        if (result.hasErrors()) {
            return "theme/add";
        }

        themeRepository.save(theme);

        return "redirect:/theme/";
    }

    @GetMapping("/{id}")
    public String showTheme(@PathVariable Long id, ModelMap model) {
        Optional<Theme> theme = themeRepository.findById(id);

        if (theme.isPresent()) {
            model.addAttribute("theme", theme.get());
            return "theme/view";
        } else
            throw new NotFoundException();
    }

    /*//TODO: make show by name always
    @GetMapping("/view/{name}")
    public String showAuthorByName(@PathVariable String name, ModelMap model) {
        Author author = themeRepository.findByName(name);

        if (null != author) {
            model.addAttribute("author", author);
            return "author/view";
        } else
            throw new NotFoundException();
    }*/

    @PostMapping("/{id}/delete")
    public String deleteTheme(@PathVariable Long id) {
        themeRepository.deleteById(id);

        return "redirect:/theme/";
    }

}
