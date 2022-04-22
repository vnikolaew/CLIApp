package com.vnikolaev.exceptions;

public abstract class CLIException extends Exception {
    protected CLIException(String message) {
        super(message);
    }
}
