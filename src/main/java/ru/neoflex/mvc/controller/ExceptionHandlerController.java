package ru.neoflex.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import ru.neoflex.mvc.exception.NotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "my not found")
    @ExceptionHandler(NotFoundException.class)
    public String error404Handler() {
        return "author/error/404";
    }
}
