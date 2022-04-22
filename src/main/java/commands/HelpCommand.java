package commands;

import abstractions.CLIQuery;

public class HelpCommand extends CLIQuery<String> {

    private static final String newLine = System.lineSeparator();
    private static final char spaceChar = ' ';
    private static final int space = 30;

    public HelpCommand() {
        super(new String[0]);
    }

    @Override
    public int getRequiredArgumentsLength() {
        return 0;
    }

    @Override
    protected QueryResult<String> executeCore() {
        StringBuilder info = new StringBuilder();
        info.append("The following commands are supported:")
                .append(newLine);

        info.append(formatLine("open", new String[] { "<file>" }, "opens a file"));
        info.append(formatLine("close", new String[0], "closes currently opened file"));
        info.append(formatLine("save", new String[0], "saves the currently opened file"));
        info.append(formatLine("saveas", new String[] { "<file>" }, "saves the currently opened file in <file>"));
        info.append(formatLine("print", new String[0], "prints the content of the currently opened file"));
        info.append(formatLine("search", new String[] { "<searchterm>" }, "queries a given key in the currently opened file"));
        info.append(formatLine("set", new String[] { "<path>", "<value>" }, "updates a given key with the new value in the currently opened file"));
        info.append(formatLine("create", new String[] { "<path>", "<value>" }, "creates a new element with the given value in the currently opened file"));
        info.append(formatLine("delete", new String[] { "<path>" }, "deletes a given key if it exists in the currently opened file"));
        info.append(formatLine("validate", new String[0], "validates the schema in the currently opened file"));
        info.append(formatLine("help", new String[0], "print this information"));
        info.append(formatLine("exit", new String[0], "exits the program"));

        return QueryResult.success(info.toString(), "");
    }

    private String formatLine(String commandName, String[] args, String commandInfo) {

        StringBuilder info = new StringBuilder();
        info.append(commandName);
        for(String arg : args) {
            info.append(spaceChar).append(arg);
        }

        padStringToLeft(info, space, spaceChar);

        info.append(spaceChar).append(commandInfo).append(newLine);

        return info.toString();
    }

    private void padStringToLeft(StringBuilder sb, int totalLength, char padChar) {
        while(sb.length() < totalLength) {
            sb.append(padChar);
        }
    }
}
