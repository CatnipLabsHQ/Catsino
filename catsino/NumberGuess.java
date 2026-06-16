import java.util.Random;

import static tools.GameData.Ansi.*;
import static tools.GameData.addMoney;
import static tools.GameData.money;
import static tools.GameData.subtractmoney;

public class NumberGuess {

  public static void numberGuess() {

    double bet;
    int guess;

    System.out.print(ANSI_CLEAR);

    // number guess Game
    int randomNumber = new Random().nextInt(3) + 1;
    System.out.println(ANSI_GREEN + "This is your balance: " + money + "$" + ANSI_RESET);
    System.out.print("Please enter your bet: ");
    bet = Catsino.input.nextDouble();

    if (bet > money) {
      System.out.println("you dont have enough money!");
      System.out.println("");

      return;
    }

    else {
      subtractmoney(bet);
      System.out.println("you can choice a number between 1 and 3");
      System.out.print("Please enter your guess: ");
      guess = Catsino.input.nextInt();

      if (guess == randomNumber) {
        double winnings = bet + (0.5 * bet);
        addMoney(winnings);
        System.out.print(ANSI_CLEAR);
        System.out.println(ANSI_GREEN + "you Win" + ANSI_RESET);
      }

      else {
        System.out.print(ANSI_CLEAR);
        System.out.println(ANSI_RED + "you lose" + ANSI_RESET);
      }
    }
  }
}
