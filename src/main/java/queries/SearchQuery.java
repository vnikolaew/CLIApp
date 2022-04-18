package queries;

import abstractions.CLIQuery;
import abstractions.JSONDataSource;
import commands.QueryResult;

import java.util.List;

public class SearchQuery extends CLIQuery<List<?>> {

    private final JSONDataSource dataSource;

    public SearchQuery(JSONDataSource dataSource, String[] args) {
        super(args);
        this.dataSource = dataSource;
    }

    @Override
    protected QueryResult<List<?>> executeCore() {
        String searchKey = args[0];

        List<?> result = dataSource.searchElement(searchKey);
        return QueryResult.success(result, "Search result: ");
    }

    @Override
    public int getRequiredArgumentsLength() {
        return 1;
    }
}
