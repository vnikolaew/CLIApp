package com.vnikolaev.abstractions;

import java.io.IOException;

public interface IODevice {
    void write(String filePath, String content) throws IOException;
    String read(String filePath) throws IOException;
}
