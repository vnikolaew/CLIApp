package com.vnikolaev.commands;

public class CommandResult {

    private final String resultMessage;
    private final boolean success;

    public CommandResult(String resultMessage, boolean success) {
        this.resultMessage = resultMessage;
        this.success = success;
    }

    public static CommandResult success(String successMessage) {
        return new CommandResult(successMessage, true);
    }

    public static CommandResult failure(String failureMessage) {
        return new CommandResult(failureMessage, false);
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return resultMessage;
    }
}
