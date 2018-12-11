package ru.neoflex.mvc.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {
        super.initCause(new Throwable("id not found"));
        super.printStackTrace();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
