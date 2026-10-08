package com.catsino;

import java.util.Scanner;


import static com.catsino.tools.GameData.Ansi.*;
import com.catsino.tools.Player;

public class CatMode {

  // Cheat Mode
  public static void catMode(Player player, Scanner scanner) {

    System.out.print(ANSI_CLEAR);
    System.out.println(ANSI_YELLOW + "You Enabled CatMode" + ANSI_RESET);

    while(true) {

      System.out.print("> ");
      var input = scanner.nextLine();

      if (input.equals("exit") || input.equals("quit")) {
        
        System.out.print(ANSI_CLEAR);

        return;
      }

      if (input.startsWith("addmoney ")) {
        String[] parts = input.split(" ");
        double amount = Double.parseDouble(parts[1]);
        player.deposit(amount);
        System.out.println(ANSI_GREEN + "+ " + amount + " $" + ANSI_RESET);
        
      }

      else if (input.startsWith("submoney ")) {
        String[] parts = input.split(" ");
        double amount = Double.parseDouble(parts[1]);

        if(!player.withdraw(amount)) {
          System.out.println("Not enough Money"); 
        }
        else {
          System.out.println(ANSI_GREEN + "- " + amount + " $" + ANSI_RESET);
        }
      }

      else if (input.equals("balance")) {
        System.out.println(ANSI_GREEN + player.getBalance() + " $" + ANSI_RESET);
      }

      else if (input.equals("clear")) {
        System.out.print(ANSI_CLEAR);
      }

      else if (input.equals("help")) {
        System.out.println(ANSI_CYAN + "Available commands:" + ANSI_RESET);
        System.out.println("  addmoney <amount>  - Add money to balance");
        System.out.println("  submoney <amount>  - Subtract money from balance");
        System.out.println("  balance            - Show current balance");
        System.out.println("  clear              - Clear screen");
        System.out.println("  exit/quit          - Exit CatMode");
      }
        
      else {
        System.out.println(ANSI_RED + " Cat Shell Unknown command. Type 'help' for options." + ANSI_RESET);
      }


    }
  }
}
