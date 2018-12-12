package ru.neoflex.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import ru.neoflex.mvc.controller.form.UserRegistrationForm;
import ru.neoflex.mvc.service.UserServiceImplementation;

@Controller
public class AuthController {
    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "auth/login";
    }

    @GetMapping("/registration")
    public String registration(ModelMap model) {
        model.addAttribute("user", new UserRegistrationForm());

        return "auth/registration";
    }

    /*@PostMapping("/login")
    public String enterUser() {
        userServiceImplementation.
    }*/
}
