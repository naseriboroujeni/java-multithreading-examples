package org.example3;

public class Main {

   public static void main(String[] args) {
      Thread longLastingThread = new Thread(() -> {
         try {
            Thread.sleep(50000);
         } catch (InterruptedException e) {
            System.out.println("Thread was intrupted");
         }
      });

      longLastingThread.start();

      longLastingThread.interrupt();
   }

}
