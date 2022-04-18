package abstractions;

import commands.CommandResult;

public interface CLIRequest {
    CommandResult execute();
    int getRequiredArgumentsLength();
}
