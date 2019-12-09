package com.bz.mc.exception;

/**
 * User: rafiq
 * Date: 30/11/19
 * Time: 8:03 PM
 */
public class ApiException extends RuntimeException {
    public ApiException(String message) {
        super(message);
    }
}
