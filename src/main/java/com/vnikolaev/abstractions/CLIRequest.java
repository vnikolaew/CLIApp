package com.vnikolaev.abstractions;

import com.vnikolaev.commands.CommandResult;

public interface CLIRequest {
    CommandResult execute();
    int getRequiredArgumentsLength();
}
