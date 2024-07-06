package com.alexnikiforov.library.exceptions;

public class SaveToDatabaseException extends RuntimeException {
    public SaveToDatabaseException() {
    }

    public SaveToDatabaseException(String message) {
        super(message);
    }

    public SaveToDatabaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
