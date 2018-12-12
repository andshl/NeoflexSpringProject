package ru.neoflex.mvc.repository;

import org.springframework.data.repository.CrudRepository;
import ru.neoflex.mvc.entity.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
}
