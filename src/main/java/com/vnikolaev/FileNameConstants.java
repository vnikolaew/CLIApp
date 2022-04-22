package com.vnikolaev;

import java.nio.file.Path;
import java.nio.file.Paths;

public class FileNameConstants {
    public static final String baseSrcDirectory =
            Path.of(Paths.get("").toAbsolutePath().toString(), "src")
            .toString();

    public static final String MainFilesDirectory =
            Path.of(baseSrcDirectory, "main", "java", "com", "vnikolaev", "files")
            .toString();

    public static final String TestFilesDirectory =
            Path.of(baseSrcDirectory, "test", "java", "com", "vnikolaev", "datasource")
                    .toString();
}
