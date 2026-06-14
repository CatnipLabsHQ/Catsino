import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

  // Ansi Color's and Clear
  public static final String ANSI_CLEAR = "\033[2J\033[H";

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";


  public static DecimalFormat decimalFormat = new DecimalFormat("#.####");


  public static void numberGuess() { 

    double bet;
    int guess;

    System.out.print(ANSI_CLEAR);

    // number guess Game
    int randomNumber = new Random().nextInt(3) + 1;
    System.out.println(ANSI_GREEN + "This is your balanc: " + Catsino.money + "$" + ANSI_RESET);
    System.out.print("Please enter your bet: ");
    bet = Catsino.input.nextDouble();

    if (bet == 13_15_14_5_25) { // money cheat code

      System.out.println("How much Money you want to add");
      System.out.print(">");

      int cheatMoney = Catsino.input.nextInt();
      Catsino.money += cheatMoney;

      return;
    } 
    else if (bet > Catsino.money) {
      System.out.println("you dont have enough money!");
      System.out.println("");
      return;
    }
    else {
      Catsino.money -= bet;
      System.out.println("you cane choice a number between 1 and 3");
      System.out.print("Please enter your guess: ");
      guess = Catsino.input.nextInt();

      if (guess == randomNumber) {
        decimalFormat.format(bet += 0.5 * bet);
        Catsino.money += bet;
        bet -= bet;
        System.out.print(ANSI_CLEAR);
        System.out.println(ANSI_GREEN + "you Win" + ANSI_RESET);
      }
      else {
        bet -= bet;
        System.out.print(ANSI_CLEAR);
        System.out.println(ANSI_RED + "you lose" + ANSI_RESET);
      }
    }
  }
}
