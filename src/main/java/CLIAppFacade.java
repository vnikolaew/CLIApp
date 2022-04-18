import abstractions.*;
import datasource.JSONDataSourceImpl;
import datasource.conversions.JSONConverterImpl;
import io.*;

public class CLIAppFacade {
    public void run() {

        JSONConverter converter = new JSONConverterImpl();
        IODevice fileIO = new FileIO();

        IODevice consoleIO = new ConsoleIO();
        JSONDataSource dataSource = new JSONDataSourceImpl(fileIO, converter);
        ((JSONDataSourceImpl) dataSource).setBaseDirectory(FileNameConstants.baseDirectory);

        CLIRequestFactory requestFactory = new CLIRequestFactoryImpl(dataSource);

        CLIApp app = new CLIApp(consoleIO, requestFactory);
        app.run();
    }

}
