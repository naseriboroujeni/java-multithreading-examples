package org.example2;

public class Vault {

   public final static int MAX_PASSWORD = 9999;

   private int password;

   public Vault(int password) {

      this.password = password;
   }

   public boolean guessPassword(int guess) {

      try {
         Thread.sleep(5);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

      return this.password == guess;
   }
}
