package org.javarush.oleksandr.IO;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
class FileServiceTest {
    @TempDir
    Path tempDir;

    Path inputFilePath;

    FileService fileService;


    @BeforeEach
    void setUp() throws IOException {
        inputFilePath = Files.createFile(tempDir.resolve(Path.of("inputFile.txt")));
        Files.writeString(inputFilePath, "Hello world!");
        fileService = new FileService();
    }

    @Test
    @DisplayName("Should read all data from given file")
    void read_positive() throws IOException {
        String actual = fileService.read(inputFilePath);
        assertEquals("Hello world!", actual);
    }

    @Test
    @DisplayName("Should throw NoSuchFileException whe specified file does not exist")
    void read_negative() throws IOException {
        Path notExistingFilePath = tempDir.resolve(Path.of("notExistingFile.txt"));

        assertThrowsExactly(NoSuchFileException.class, () -> fileService.read(notExistingFilePath));
    }


    @ParameterizedTest
    @CsvSource({
            "./file.txt, (decrypted), ./file(decrypted).txt"
    })
    void addFileNameAnnotation(String filePath, String annotation, String expected) {
        Path path = Path.of(filePath);

        Path actual = fileService.addFileNameAnnotation(path, annotation);


        assertAll("Message", () -> {
            assertEquals(expected, actual.toString());
            assertTimeout(Duration.ofSeconds(1), () -> fileService.addFileNameAnnotation(path, annotation));
        });
    }
}