package io;

import abstractions.IODevice;

import java.util.Scanner;

public class ConsoleIO implements IODevice {

    @Override
    public void write(String filePath, String content) {
        System.out.println(content);
    }

    @Override
    public String read(String filePath) {
        return new Scanner(System.in).nextLine();
    }
}
