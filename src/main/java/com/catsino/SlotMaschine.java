package com.catsino;

import java.util.Random;
import java.util.Scanner;

import static com.catsino.tools.GameData.addMoney;
import static com.catsino.tools.GameData.money;
import static com.catsino.tools.GameData.Ansi.*;


public class SlotMaschine {

  public static void slotMaschine(){ 

    Scanner scanner = new Scanner(System.in);
    double bet = 0.0;

    System.out.println(ANSI_PURPLE + "quit with typing a letter" + ANSI_RESET);
    System.out.println(ANSI_GREEN + "your balance: " + money + "$" + ANSI_RESET);
   

    while (true) {
    
      // if input is not a nummber you go to the main menu
      try {
        bet = scanner.nextDouble();
      } catch (Exception e) {
      break;
      }
      
      if (bet <= money) {
        money -= bet;
        
        // Symboles Array, Empty Array for the Slots, Random object 
        String[] symboles = {"🐈", "🐱", "💰"};
        String[] row = new String[3];
        Random random = new Random();

        // creates 3 Random Symboles from the list
        for (int i = 0; i < 3; i++) {
          row[i] = symboles[random.nextInt(symboles.length)];
        }
       
        // checking if the 3 Random symboles matches 
        if (row[0].equals(row[1]) && row[1].equals(row[2])) {

          if (row[0].equals("🐈")) { 
            bet *= 2;
            System.out.print(ANSI_CLEAR);
            System.out.println(ANSI_GREEN + "You won 2x money" + ANSI_RESET);
          }
          else if (row[0].equals("🐱")) {
            bet *= 3;
            System.out.print(ANSI_CLEAR);
            System.out.println(ANSI_GREEN + "You won 3x money" + ANSI_RESET);
          }
          else if (row[0].equals("💰")) {
            bet *=5;
            System.out.print(ANSI_CLEAR);
            System.out.println(ANSI_GREEN + "You won 5x money" + ANSI_RESET);
          }
          addMoney(bet);
        }
        else {
          System.out.print(ANSI_CLEAR);
          System.out.println(ANSI_RED + "you lose: " + bet + "$" + ANSI_RESET);
        }

        // Visual slotmaschine Output
        System.out.println(ANSI_GREEN + "your balance: " + money + "$" + ANSI_RESET);
        System.out.print(ANSI_YELLOW);
        System.out.println("╔══╦══╦══╗");
        System.out.println("║" + row[0] + "║" + row[1] + "║" + row[2] + "║");
        System.out.println("╚══╩══╩══╝");
        System.out.print(ANSI_RESET);

      } // if not enough money check 
      else if (bet > money) {
        System.out.print(ANSI_CLEAR);
        System.out.println(ANSI_RED + "Not Enough money" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "your balance: " + money + "$" + ANSI_RESET);
      }

    }
  System.out.print(ANSI_CLEAR);
  }
}

