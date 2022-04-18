package abstractions;

import commands.CommandResult;

public abstract class CLICommand implements CLIRequest {

    protected final String[] args;

    protected CLICommand(String[] args) {
        this.args = args;
    }

    @Override
    public CommandResult execute() {
        return args.length == getRequiredArgumentsLength()
                ? executeCore()
                : CommandResult.failure("Invalid arguments.");
    }

    protected abstract CommandResult executeCore();
}
