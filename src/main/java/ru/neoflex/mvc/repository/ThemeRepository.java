package ru.neoflex.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.neoflex.mvc.entity.Theme;

import java.util.List;

public interface ThemeRepository extends PagingAndSortingRepository<Theme, Long> {
    Iterable<Theme> findByIdBetween(Long a, Long b);

}
