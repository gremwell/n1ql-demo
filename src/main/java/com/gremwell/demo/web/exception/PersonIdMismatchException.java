package com.gremwell.demo.web.exception;

public class PersonIdMismatchException extends RuntimeException {

    public PersonIdMismatchException() {
        super();
    }

    public PersonIdMismatchException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public PersonIdMismatchException(final String message) {
        super(message);
    }

    public PersonIdMismatchException(final Throwable cause) {
        super(cause);
    }
}
