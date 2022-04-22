package com.vnikolaev;

import com.vnikolaev.abstractions.CLIRequest;
import com.vnikolaev.abstractions.CLIRequestFactory;
import com.vnikolaev.abstractions.IODevice;
import com.vnikolaev.commands.*;
import java.io.IOException;

public final class CLIApp {

    private final IODevice ioDevice;
    private final CLIRequestFactory requestFactory;

    public CLIApp(IODevice ioDevice, CLIRequestFactory factory) {
        this.ioDevice = ioDevice;
        this.requestFactory = factory;
    }

    public void run() {
        while (true) {
            processRequest();
        }
    }

    private void processRequest() {
        String input = readInput();

        CLIRequest cliRequest = requestFactory.createRequest(input);
        CommandResult result = cliRequest.execute();

        displayResult(result);
    }

    private void displayResult(CommandResult result) {
        try {
            ioDevice.write("", result.getResultMessage());
            if(result instanceof QueryResult<?> && ((QueryResult<?>) result).getData() != null) {
                ioDevice.write("", ((QueryResult<?>) result).getData().toString());
            }
        } catch (IOException ignored) { }
    }

    private String readInput() {
        try {
            return ioDevice.read("").trim();
        } catch (IOException e) {
            return null;
        }
    }

}
