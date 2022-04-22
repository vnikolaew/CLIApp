package com.vnikolaev;

import com.vnikolaev.abstractions.*;
import com.vnikolaev.datasource.JSONDataSourceImpl;
import com.vnikolaev.datasource.conversions.JSONConverterImpl;
import com.vnikolaev.io.*;

public class CLIAppFacade {

    public void run(String[] args) {
        CLIApp app = buildApp();
        app.run();
    }

    private CLIApp buildApp() {
        JSONConverter converter = new JSONConverterImpl();
        IODevice fileIO = new FileIO();

        IODevice consoleIO = new ConsoleIO();
        JSONDataSource dataSource = new JSONDataSourceImpl(fileIO, converter);
        ((JSONDataSourceImpl) dataSource).setBaseDirectory(FileNameConstants.MainFilesDirectory);

        CLIRequestFactory requestFactory = new CLIRequestFactoryImpl(dataSource);

        return new CLIApp(consoleIO, requestFactory);
    }


}
