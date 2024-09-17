package org.example8;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();

        IncrementorThread incrementorThread = new IncrementorThread(inventoryCounter);
        DecrementorThread decrementorThread = new DecrementorThread(inventoryCounter);

        incrementorThread.start();
        decrementorThread.start();

        incrementorThread.join();
        decrementorThread.join();

        System.out.println("Total Count: " + inventoryCounter.getCount());
    }

    public static class IncrementorThread extends Thread {
        InventoryCounter inventoryCounter;

        public IncrementorThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    public static class DecrementorThread extends Thread {
        InventoryCounter inventoryCounter;

        public DecrementorThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    public static class InventoryCounter {

        private int count;

        public InventoryCounter() {
            this.count = 0;
        }

        public void increment() {
            synchronized (this) {
                count++;
            }
        }

        public synchronized void decrement() {
            count--;
        }

        public int getCount() {
            return count;
        }
    }
}
