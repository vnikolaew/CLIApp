package commands;

import abstractions.CLICommand;
import datasource.DataSourceOperationResult;
import abstractions.JSONDataSource;

public class OpenCommand extends CLICommand {

    private final JSONDataSource dataSource;

    public OpenCommand(JSONDataSource dataSource, String[] args) {
        super(args);
        this.dataSource = dataSource;
    }

    @Override
    public int getRequiredArgumentsLength() {
        return 1;
    }

    @Override
    protected CommandResult executeCore() {
        String filePath = args[0];

        DataSourceOperationResult result = dataSource.open(filePath);

        return result.isSuccessful()
                ? CommandResult.success(result.getSuccessMessage())
                : CommandResult.failure(result.getErrors().get(0));
    }
}
