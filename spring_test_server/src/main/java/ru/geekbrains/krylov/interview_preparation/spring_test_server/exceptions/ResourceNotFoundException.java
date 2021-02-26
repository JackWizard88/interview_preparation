package ru.geekbrains.krylov.interview_preparation.spring_test_server.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
