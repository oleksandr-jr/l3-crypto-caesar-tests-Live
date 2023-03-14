package org.javarush.oleksandr;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.javarush.oleksandr.IO.FileService;
import org.javarush.oleksandr.cipher.Caesar;
import org.javarush.oleksandr.constants.Constants;
import org.javarush.oleksandr.runner.SimpleRunner;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    private static final Logger log = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
//        Configurator.setAllLevels(log.getName(), Level.getLevel("DEBUG"));
        log.trace("1");
        log.debug("2");
        log.info("3");
        log.warn("4");
        log.error("5");
        log.fatal("6");

        Caesar caesar = new Caesar(Constants.ALPHABET_EN);
        FileService fileService = new FileService();

        SimpleRunner runner = new SimpleRunner(caesar, fileService);

        if (args.length > 0) {
            runner.run(args[0], Path.of(args[1]), Integer.parseInt(args[2]));
        }else{
            cliStart();
        }

    }
    public static void cliStart() {
        Console.setColor(Console.color.BLUE);
        System.out.println("Select command: ");
        System.out.println("[1] Encode");
        System.out.println("[2] Decode");

        Scanner sc = new Scanner(in);

        int command = 0;
        try {
            command = sc.nextInt();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}