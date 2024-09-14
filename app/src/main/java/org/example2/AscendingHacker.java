package org.example2;

public class AscendingHacker extends Hacker {

   public AscendingHacker(Vault vault) {
      super(vault);
   }

   @Override
   public void run() {
      for (int guess = 0; guess <= Vault.MAX_PASSWORD; guess++) {
         if (vault.guessPassword(guess)) {
            System.out.println(this.getName() + " guessed the password " + guess);
            System.exit(0);
         }
      }
   }
}
