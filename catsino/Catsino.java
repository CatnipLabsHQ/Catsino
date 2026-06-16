import java.util.Scanner;

import static tools.GameData.Ansi.*;
import static tools.GameData.addMoney;
import static tools.GameData.money;

public class Catsino {

  // Importan Stuff
  public static Scanner input = new Scanner(System.in);

  public static void main(String[] args) {

    try {
      Startup.startupMain();
    } catch (InterruptedException e) {}

    // clear's Terminal Screen
    System.out.print(ANSI_CLEAR);

    while (true) {
      // Introduction
      System.out.println(ANSI_PURPLE + "Welcome to Catsino!" + ANSI_RESET);
      System.out.println(ANSI_GREEN + "Your Balance: " + money + "$" + ANSI_RESET);
      System.out.println("[1] Start Playing");
      System.out.println("[2] Save");
      System.out.println("[3] Load");
      System.out.println("[4] Tutorial");
      System.out.println("[5] Exit");
      System.out.print("What is your choice: ");

      String userInput = input.nextLine();

      if (userInput.equals("1")) {
        NumberGuess.numberGuess();
        input.nextLine();
      }

      else if (userInput.equals("2")) {
        // Save System
        System.out.print(ANSI_CLEAR);
        System.out.print("Save Game? (y/n) \n>");

        userInput = input.nextLine().trim().toLowerCase();

        if (userInput.equals("y")) {
          SaveSystem.save(money);
          System.out.print(ANSI_CLEAR);
          System.out.println(ANSI_GREEN + "Game Save" + ANSI_RESET);
        } else {
          System.out.print(ANSI_CLEAR);
          System.out.println(ANSI_RED + "Save Canceled" + ANSI_RESET);
        }
      }

      else if (userInput.equals("3")) {
        money = SaveSystem.load();
        System.out.print(ANSI_CLEAR);
      }

      else if (userInput.equals("4")) {
        // Tutorial
        System.out.print(ANSI_CLEAR);
        System.out.println("Tutorial coming soon...");

        input.nextLine();
        System.out.print(ANSI_CLEAR);
      }

      else if (userInput.equals("5")) {
        System.out.print(ANSI_CLEAR);
        System.out.println(ANSI_BLUE + "Thanks for playing!" + ANSI_RESET);
        System.exit(0);
      }
      else if (userInput.equals("catmode")) {
        System.out.print(ANSI_CLEAR);
        
        System.out.print(ANSI_YELLOW + "you enabled CatMode \nHow much money you want to add? \n>" + ANSI_RESET);
        double cheatMoney = input.nextDouble();
        addMoney(cheatMoney);
        System.out.print(ANSI_CLEAR);

      }

      else {
        System.out.print(ANSI_CLEAR);
      }
    }
  }
}
