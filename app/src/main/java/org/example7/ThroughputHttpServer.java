package org.example7;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThroughputHttpServer {

    private int numberOfThreads;

    public ThroughputHttpServer(int numberOfThreads) {
        System.out.println(numberOfThreads);
        this.numberOfThreads = numberOfThreads;
    }

    public void startServer(String text) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/search", new WordCountHandler(text));
        Executor executor = Executors.newFixedThreadPool(numberOfThreads);
        server.setExecutor(executor);
        server.start();
    }
}
