package org.example9;

public class MetricsPrinter extends Thread {

    private final Metrics metrics;

    public MetricsPrinter(Metrics metrics) {
        this.metrics = metrics;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            System.out.println("Current Average: " + metrics.getAverage());

        }
    }
}
