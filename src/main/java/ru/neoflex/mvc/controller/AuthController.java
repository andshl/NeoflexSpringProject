package ru.neoflex.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.neoflex.mvc.controller.form.UserRegistrationForm;
import ru.neoflex.mvc.entity.User;
import ru.neoflex.mvc.service.UserService;
import ru.neoflex.mvc.service.UserServiceImplementation;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

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

    @PostMapping("/registration")
    public String register(@ModelAttribute("userForm") UserRegistrationForm userRegistrationForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "auth/registration";

        User user = new User();
        user.setUsername(userRegistrationForm.getUsername());
        user.setPassword(userRegistrationForm.getPassword());

        userService.signupUser(user);

        return "redirect:/";
    }

    /*@PostMapping("/login")
    public String enterUser() {
        userServiceImplementation.
    }*/
}
