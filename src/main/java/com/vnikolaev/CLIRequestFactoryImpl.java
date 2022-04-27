package com.vnikolaev;

import com.vnikolaev.abstractions.*;
import com.vnikolaev.commands.*;
import com.vnikolaev.queries.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CLIRequestFactoryImpl implements CLIRequestFactory {

    private static final Map<String, Class<?>> requestMap;

    private final JSONDataSource dataSource;

    static {
        requestMap = new HashMap<>();
        requestMap.put("open", OpenCommand.class);
        requestMap.put("close", CloseCommand.class);
        requestMap.put("save", SaveCommand.class);
        requestMap.put("saveas", SaveAsCommand.class);
        requestMap.put("print", PrintQuery.class);
        requestMap.put("search", SearchQuery.class);
        requestMap.put("set", UpdateCommand.class);
        requestMap.put("create", CreateCommand.class);
        requestMap.put("delete", DeleteCommand.class);
        requestMap.put("exit", ExitCommand.class);
        requestMap.put("help", HelpCommand.class);
        requestMap.put("validate", ValidateSchemaCommand.class);
    }

    public CLIRequestFactoryImpl(JSONDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public CLIRequest createRequest(String requestString) {
        String[] requestSegments = getRequestSegments(requestString);

        String action = getAction(requestSegments);
        String[] arguments = getArguments(requestSegments);

        Class<?> requestType = requestMap.getOrDefault(action, InvalidCommand.class);

        return makeRequest(requestType, arguments);
    }

    private CLIRequest makeRequest(Class<?> requestType, String[] arguments) {
        try {
            if(requestType.equals(ExitCommand.class)) {
                return new ExitCommand();
            }
            if(requestType.equals(HelpCommand.class)) {
                return new HelpCommand(new DefaultCommandDescriptionFormatter());
            }

            return (CLIRequest) requestType
                            .getConstructors()[0]
                            .newInstance(dataSource, arguments);
        } catch (Exception e) {
            return new InvalidCommand();
        }
    }

    private String[] getRequestSegments(String requestString) {
        return requestString.trim().split(" ");
    }

    private String[] getArguments(String[] requestSegments) {
        return Arrays.copyOfRange(requestSegments, 1, requestSegments.length);
    }

    private String getAction(String[] requestSegments) {
        return requestSegments[0].toLowerCase();
    }
}
