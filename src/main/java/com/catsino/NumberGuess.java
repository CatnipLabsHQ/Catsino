package com.catsino;

import java.util.Random;
import java.util.Scanner;

import static com.catsino.tools.GameData.Ansi.*;
import com.catsino.tools.Player;

public class NumberGuess {

  public static void numberGuess(Player player, Scanner scanner) {
    
    // Variables
    double bet;
    int guess;
    int randomNumber = new Random().nextInt(3) + 1;


    System.out.print(ANSI_CLEAR);

    // number guess Game
    System.out.println(ANSI_GREEN + "This is your balance: " + player.getBalance() + "$" + ANSI_RESET);
    System.out.print("Please enter your bet: ");

    try {
      bet = Double.parseDouble(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.print(ANSI_CLEAR);
        return;
    }
    
    if(!player.withdraw(bet)) {
      System.out.println("Not enough Money");
      return;
    }
    System.out.println("you can choice a number between 1 and 3");
    System.out.print("Please enter your guess: ");
    try {
        guess = Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
        System.out.print(ANSI_CLEAR);
        return;
    }

    if (guess == randomNumber) {
      double winnings = bet + (0.5 * bet);
      player.deposit(winnings);
      System.out.print(ANSI_CLEAR);
      System.out.println(ANSI_GREEN + "you Win" + ANSI_RESET);
    }

    else {
      System.out.print(ANSI_CLEAR);
      System.out.println(ANSI_RED + "you lose" + ANSI_RESET);  
    }
  }
}
