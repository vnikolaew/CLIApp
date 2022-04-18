package commands;

import abstractions.CLICommand;
import datasource.DataSourceOperationResult;
import abstractions.JSONDataSource;

public class DeleteCommand extends CLICommand {

    private final JSONDataSource dataSource;

    public DeleteCommand(JSONDataSource dataSource, String[] args) {
        super(args);
        this.dataSource = dataSource;
    }

    @Override
    public int getRequiredArgumentsLength() {
        return 1;
    }

    @Override
    protected CommandResult executeCore() {
        String path = args[0];

        if(path == null) {
            return CommandResult.failure("Invalid command parameters");
        }

        DataSourceOperationResult result = dataSource.deleteElement(path);

        return result.isSuccessful()
                ? CommandResult.success(result.getSuccessMessage())
                : CommandResult.failure(result.getErrors().get(0));
    }
}
