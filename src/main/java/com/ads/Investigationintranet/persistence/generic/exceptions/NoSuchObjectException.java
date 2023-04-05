package com.ads.Investigationintranet.persistence.generic.exceptions;

public class NoSuchObjectException extends RuntimeException {
    private static final long serialVersionUID = -1741315463032269486L;

    public NoSuchObjectException() {
    }

    public NoSuchObjectException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchObjectException(String message) {
        super(message);
    }

    public NoSuchObjectException(Throwable cause) {
        super(cause);
    }
}