package commands;

import abstractions.CLICommand;

public class InvalidCommand extends CLICommand {

    public InvalidCommand() {
        super(new String[0]);
    }

    @Override
    public int getRequiredArgumentsLength() {
        return 0;
    }

    @Override
    protected CommandResult executeCore() {
        return CommandResult.failure("Invalid / unsupported command.");
    }
}
