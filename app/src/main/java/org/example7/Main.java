package org.example7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    private static final String INPUT_FILE = "app/resources/war_and_peace.txt";
    private static final int NUMBER_OF_THREADS = 2;

    public static void main(String[] args) throws IOException {
        String text = new String(Files.readAllBytes(Paths.get(INPUT_FILE)));
        ThroughputHttpServer throughputHttpServer = new ThroughputHttpServer(NUMBER_OF_THREADS);
        throughputHttpServer.startServer(text);
    }
}
