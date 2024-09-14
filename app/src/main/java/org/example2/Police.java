package org.example2;

public class Police extends Thread {

   @Override
   public void run() {

      for (int i = 0; i < 10; i++) {
         try {
            Thread.sleep(1000);
         } catch (InterruptedException e) {
            e.printStackTrace();
         }

         System.out.println(i);
      }
      System.out.println("Game over for you hackers");
      System.exit(0);
   }
}
