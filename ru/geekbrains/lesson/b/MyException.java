package ru.geekbrains.lesson.b;

public class MyException extends RuntimeException {

    private String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Exception: " + message;
    }
}