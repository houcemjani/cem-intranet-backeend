package com.ads.Investigationintranet.persistence.generic.exceptions;

public class PersistException extends Exception {
    private static final long serialVersionUID = 7673869918124222409L;

    public PersistException() {
    }

    public PersistException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistException(String message) {
        super(message);
    }

    public PersistException(Throwable cause) {
        super(cause);
    }
}
