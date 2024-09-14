package org.example2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

   public static void main(String[] args) {
      Random random = new Random();
      Vault vault = new Vault(random.nextInt(Vault.MAX_PASSWORD));

      List<Thread> threads = new ArrayList<>();
      threads.add(new AscendingHacker(vault));
      threads.add(new DescendingHacker(vault));
      threads.add(new Police());

      threads.forEach(thread -> thread.start());
   }
}
