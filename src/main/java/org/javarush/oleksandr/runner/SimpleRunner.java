package org.javarush.oleksandr.runner;

import org.javarush.oleksandr.IO.FileService;
import org.javarush.oleksandr.cipher.Cipher;

import java.io.IOException;
import java.nio.file.Path;

public class SimpleRunner implements Runner{
    Cipher cipher;
    FileService fileService;

    public SimpleRunner(Cipher cipher, FileService fileService) {
        this.cipher = cipher;
        this.fileService = fileService;
    }

    public void run(String command, Path filePath, int key) throws IOException {

        if (command.equals("encrypt")) {
            Path decryptedFilePath = fileService.addFileNameAnnotation(filePath, "(encrypted)");
            String fileText = fileService.read(filePath);
            String encryptedText = cipher.encrypt(fileText, key);
            fileService.write(decryptedFilePath, encryptedText);
        } else if (command.equals("decrypt")) {
            Path decryptedFilePath = fileService.addFileNameAnnotation(filePath, "(decrypted)");
            String fileText = fileService.read(filePath);
            String decryptedText = cipher.decrypt(fileText, key);
            fileService.write(decryptedFilePath, decryptedText);
        } else {
            System.out.println("Unknown command try [encrypt] or [decrypt]");
            System.out.println("Follow this pattern [command] [path to the file] [key]");
            System.out.println("Example: encrypt \"C\\file.txt\" 5");
        }
    }
}
