package commands;
import abstractions.CLICommand;

public class ExitCommand extends CLICommand {

    public ExitCommand() {
        super(new String[0]);
    }

    @Override
    public int getRequiredArgumentsLength() {
        return 0;
    }

    @Override
    protected CommandResult executeCore() {
        exitGracefully();
        return CommandResult.success("Exiting the app ...");
    }
    
    private void exitGracefully() {
        System.out.println("Exiting app ...");
        System.exit(0);
    }

}
