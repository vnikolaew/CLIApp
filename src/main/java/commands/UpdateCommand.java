package commands;

import abstractions.CLICommand;
import datasource.DataSourceOperationResult;
import abstractions.JSONDataSource;

public class UpdateCommand extends CLICommand {

    private final JSONDataSource dataSource;

    public UpdateCommand(JSONDataSource dataSource, String[] args) {
        super(args);
        this.dataSource = dataSource;
    }

    @Override
    public int getRequiredArgumentsLength() {
        return 2;
    }

    @Override
    protected CommandResult executeCore() {
        String path = args[0];
        String payload = args[1];

        if(path == null || payload == null) {
            return CommandResult.failure("Invalid command parameters");
        }

        DataSourceOperationResult result = dataSource.setElement(path, payload);

        return result.isSuccessful()
                ? CommandResult.success(result.getSuccessMessage())
                : CommandResult.failure(result.getErrors().get(0));
    }
}
