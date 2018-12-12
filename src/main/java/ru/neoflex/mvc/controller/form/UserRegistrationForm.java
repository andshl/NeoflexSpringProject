package ru.neoflex.mvc.controller.form;

import lombok.Data;

@Data
public class UserRegistrationForm {
    private String username;
    private String pasword;
    private String confirmPasword;
}
