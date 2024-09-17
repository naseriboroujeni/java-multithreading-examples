package org.example9;

public class Metrics {

    private int count;
    private volatile double average;

    public Metrics() {
        count = 0;
        average = 0;
    }

    public synchronized void addSample(long sample) {
        double currentSum = count * average;
        count++;
        average = (currentSum + sample) / count;
    }

    public double getAverage() {
        return average;
    }
}
