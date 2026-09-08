package com.catsino;

import java.util.Random;

import static com.catsino.tools.GameData.Ansi.*;
import com.catsino.tools.Player;

public class NumberGuess {

  public static void numberGuess(Player player) {

    double bet;
    int guess;

    System.out.print(ANSI_CLEAR);

    // number guess Game
    int randomNumber = new Random().nextInt(3) + 1;
    System.out.println(ANSI_GREEN + "This is your balance: " + player.getBalance() + "$" + ANSI_RESET);
    System.out.print("Please enter your bet: ");
    bet = Catsino.input.nextDouble();
    
    if(!player.withdraw(bet)) {
      System.out.println("Not enough Money");
      return;
    }
    System.out.println("you can choice a number between 1 and 3");
    System.out.print("Please enter your guess: ");
    guess = Catsino.input.nextInt();

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
