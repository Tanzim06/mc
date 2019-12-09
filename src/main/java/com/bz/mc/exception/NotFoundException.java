package com.bz.mc.exception;

/**
 * User: rafiq
 * Date: 9/11/19
 * Time: 10:04 AM
 */
public class NotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1346661033386714510L;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
    }
}
