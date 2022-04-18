package commands;

import abstractions.CLICommand;
import datasource.DataSourceOperationResult;
import abstractions.JSONDataSource;

public class SaveCommand extends CLICommand {

    private final JSONDataSource dataSource;

    public SaveCommand(JSONDataSource dataSource, String[] args) {
        super(args);
        this.dataSource = dataSource;
    }

    @Override
    public int getRequiredArgumentsLength() {
        return 0;
    }

    @Override
    protected CommandResult executeCore() {
        DataSourceOperationResult result = dataSource.save();

        return result.isSuccessful()
                ? CommandResult.success(result.getSuccessMessage())
                : CommandResult.failure(result.getErrors().get(0));
    }
}
