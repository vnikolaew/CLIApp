package queries;

import abstractions.CLIQuery;
import abstractions.JSONDataSource;
import commands.QueryResult;

public class PrintQuery extends CLIQuery<String> {

    private final JSONDataSource dataSource;

    public PrintQuery(JSONDataSource dataSource, String[] args) {
        super(args);
        this.dataSource = dataSource;
    }

    @Override
    protected QueryResult<String> executeCore() {
        String content = dataSource.toFriendlyString();

        return content == null
                ? QueryResult.failure("No content available", null)
                :  QueryResult.success(content, "JSON schema: \n");
    }

    @Override
    public int getRequiredArgumentsLength() {
        return 0;
    }
}
