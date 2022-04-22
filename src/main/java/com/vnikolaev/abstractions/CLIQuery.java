package com.vnikolaev.abstractions;

import com.vnikolaev.commands.QueryResult;

public abstract class CLIQuery<T> implements CLIRequest {

    protected final String[] args;

    protected CLIQuery(String[] args) {
        this.args = args;
    }

    public QueryResult<T> execute() {
        return args.length == getRequiredArgumentsLength()
                ? executeCore()
                : QueryResult.failure("Invalid arguments.", null);
    }

    protected abstract QueryResult<T> executeCore();
}
