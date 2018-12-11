package ru.neoflex.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import ru.neoflex.mvc.entity.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    String findByName(String name);
}
