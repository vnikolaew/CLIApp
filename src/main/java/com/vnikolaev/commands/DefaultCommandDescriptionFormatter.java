package com.vnikolaev.commands;

import com.vnikolaev.abstractions.CommandDescriptionFormatter;
import com.vnikolaev.requestdescriptors.RequestDescriptor;

public class DefaultCommandDescriptionFormatter
        implements CommandDescriptionFormatter {

    private static final String newLine = System.lineSeparator();
    private static final char spaceChar = ' ';
    private static final int space = 30;

    @Override
    public String formatLine(RequestDescriptor descriptor) {
        StringBuilder info = new StringBuilder();
        info.append(descriptor.getCommandName());
        for(String arg : descriptor.getArgs()) {
            info.append(spaceChar).append(arg);
        }

        padStringToLeft(info, space, spaceChar);

        info.append(spaceChar).append(descriptor.getCommandInfo()).append(newLine);

        return info.toString();
    }

    private void padStringToLeft(StringBuilder sb, int totalLength, char paddingChar) {
        while(sb.length() < totalLength) {
            sb.append(paddingChar);
        }
    }
}
