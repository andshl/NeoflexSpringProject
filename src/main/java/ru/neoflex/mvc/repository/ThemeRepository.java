package ru.neoflex.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import ru.neoflex.mvc.entity.Theme;

public interface ThemeRepository extends CrudRepository<Theme, Long> {
}
