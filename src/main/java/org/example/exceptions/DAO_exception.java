package org.example.exceptions;

public class DAO_exception extends Exception{

    public DAO_exception(String message) {
        super(message);
    }

    public DAO_exception(String message, Throwable cause) {
        super(message, cause);
    }

    public DAO_exception(Throwable cause) {
        super(cause);
    }
}
