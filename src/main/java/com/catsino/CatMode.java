package com.catsino;

import java.util.Scanner;

import static com.catsino.tools.GameData.addMoney;
import static com.catsino.tools.GameData.money;
import static com.catsino.tools.GameData.subtractmoney;
import static com.catsino.tools.GameData.Ansi.*;

public class CatMode {

  // Cheat Mode
  public static void catMode() {

    Scanner scanner = new Scanner(System.in);

    System.out.print(ANSI_CLEAR);
    System.out.println(ANSI_YELLOW + "You Enabled CatMode" + ANSI_RESET);

    while (true) {

      System.out.print("> ");
      var input = scanner.nextLine();

      if (input.equals("exit") || input.equals("quit")) {
        
        System.out.print(ANSI_CLEAR);

        return;
      }

      if (input.startsWith("addmoney ")) {
        String[] parts = input.split(" ");
        double amount = Double.parseDouble(parts[1]);

        System.out.println(ANSI_GREEN + "+ " + amount + " $" + ANSI_RESET);
        addMoney(amount);
      }

      else if (input.startsWith("submoney ")) {
        String[] parts = input.split(" ");
        double amount = Double.parseDouble(parts[1]);

        System.out.println(ANSI_GREEN + "- " + amount + " $" + ANSI_RESET);
        subtractmoney(amount);
      }

      else if (input.equals("balance")) {
        System.out.println(ANSI_GREEN + money + " $" + ANSI_RESET);
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
