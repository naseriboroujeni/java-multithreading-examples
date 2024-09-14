package org.example;

public class App {

    private static int numberOfPrints = 10;

    public static void main(String[] args) {

        Thread myThread = new Thread(() -> {
            for (int i = 0; i < numberOfPrints; i++) {

                System.out.println("Inside the thread " + i);
                if (i == 9) {
                    int a = 5 / 0;
                }
            }
        });

        myThread.setName("My Thread");
        myThread.setPriority(Thread.MAX_PRIORITY);

        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        System.out.println("Befor thread " + myThread.getName());

        myThread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("Critical exeption in thread " + t.getName() + ": " + e.getMessage());
        });

        myThread.start();

        Thread.yield();

        for (int i = 0; i < numberOfPrints; i++) {

            System.out.println("After thread " + myThread.getName() + " " + i);
        }
    }
}
