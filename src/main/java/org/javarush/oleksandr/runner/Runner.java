package org.javarush.oleksandr.runner;

import java.io.IOException;
import java.nio.file.Path;

public interface Runner {
    void run(String command, Path filePath, int key)throws IOException;
}
