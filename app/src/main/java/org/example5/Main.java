package org.example5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Long> inputNumbers = Arrays.asList(0L, 3435000000L, 35435L, 2324L, 4656L, 23L, 5556L);

        List<FactorialThread> threads = new ArrayList<>();

        inputNumbers.forEach(inputNumber -> threads.add(new FactorialThread(inputNumber)));

        threads.forEach(thread -> {
            thread.setDaemon(true);
            thread.start();
        });

        threads.forEach(thread -> {
            try {
                thread.join(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        for (int i = 0; i < inputNumbers.size(); i++) {
            FactorialThread factorialThread = threads.get(i);
            if (factorialThread.isFinished()) {
                System.out.println("Factorial of " + inputNumbers.get(i) + " is " + factorialThread.getResult());
            } else {
                System.out.println("The calculation for factorial of " + inputNumbers.get(i) + " is still in progress");
            }
        }
    }
}
