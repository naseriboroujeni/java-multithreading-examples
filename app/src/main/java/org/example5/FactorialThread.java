package org.example5;

import java.math.BigInteger;

public class FactorialThread extends Thread {

   private final long inputNumber;
   private BigInteger result;
   private boolean isFinished = false;

   public FactorialThread(long inputNumber) {
      this.inputNumber = inputNumber;
   }

   @Override
   public void run() {

      result = factorial();
      isFinished = true;
   }

   public BigInteger factorial() {
      BigInteger tempResult = BigInteger.ONE;

      for (long i = inputNumber; i > 0; i--) {

         tempResult = tempResult.multiply(BigInteger.valueOf(i));
      }
      return tempResult;
   }

   public BigInteger getResult() {
      return result;
   }

   public boolean isFinished() {
      return isFinished;
   }
}
