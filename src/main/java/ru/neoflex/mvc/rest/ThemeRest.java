package ru.neoflex.mvc.rest;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.mvc.entity.Theme;
import ru.neoflex.mvc.exception.NotFoundException;
import ru.neoflex.mvc.repository.ThemeRepository;

import java.util.Optional;

@RestController
@RequestMapping("/theme/rest")
public class ThemeRest {

    private ThemeRepository themeRepository;
    public ThemeRest(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @GetMapping("/{id}")
    public Theme showTheme(@PathVariable Long id, ModelMap model) {
        Optional<Theme> theme = themeRepository.findById(id);

        if (theme.isPresent()) {
            return theme.get();
        } else
            throw new NotFoundException();
    }
}
