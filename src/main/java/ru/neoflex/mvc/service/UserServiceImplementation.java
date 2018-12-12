package ru.neoflex.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.neoflex.mvc.entity.User;
import ru.neoflex.mvc.repository.UserRepository;

import java.util.Objects;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (Objects.isNull(user))
            throw new UsernameNotFoundException("user not found " + username);

        return user;
    }

    @Override
    public User signupUser(User user) {
        return null;
    }

    @Override
    public User getCurrentUser() {
        return null;
    }

    @Override
    public boolean hasRole(String role) {
        return false;
    }
}
