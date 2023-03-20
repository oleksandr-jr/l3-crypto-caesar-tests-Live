package org.javarush.oleksandr;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static final Logger log = LogManager.getLogger(MainTest.class);
    @Test
    void main() throws IOException {

        log.debug("Test");

        System.out.println("asd");
    }
}