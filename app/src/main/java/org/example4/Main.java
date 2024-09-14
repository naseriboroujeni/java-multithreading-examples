package org.example4;

import java.math.BigInteger;

public class Main {

   public static void main(String[] args) {
      Thread longComputationThread = new Thread(
            new LongComputationTask(
                  new BigInteger("20000"),
                  new BigInteger("200000000")));
      longComputationThread.start();
      longComputationThread.interrupt();

      Thread longComputationThread2 = new Thread(
            new LongComputationTask(
                  new BigInteger("20000"),
                  new BigInteger("200000000")));
      longComputationThread2.setDaemon(true);
      longComputationThread2.start();
   }
}
