package org.example9;

import java.util.Random;

public class BusinessLogic extends Thread {

    private final Metrics metrics;
    private final Random random;

    public BusinessLogic(Metrics metrics) {

        this.metrics = metrics;
        random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            long startTime = System.currentTimeMillis();
            try {
                Thread.sleep(random.nextInt(20));
            } catch (InterruptedException e) {
            }
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            metrics.addSample(elapsedTime);
        }
    }
}
