import java.util.Random;
import java.util.Scanner;

public class Catsino {

  // Ansi Color's and Clear
  public static final String ANSI_CLEAR = "\033[2J\033[H";

  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";

  // Game Stats
  public static double money = 100;

  // Importan Stuff
  public static Scanner input = new Scanner(System.in);
  
    
  public static void main(String[] args) { 

    try {
      Startup startup = new Startup();
      startup.startupMain();
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
        }
        else {
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
        System.out.println("");
        System.out.println("This is a simple Casino Game!");
        System.out.println("Don't worry, no real money is needed");
        System.out.println("The game is very simple!");
        System.out.println("You start with 100$");
        System.out.println("Your goal is to earn as much as you can");
        System.out.println("if you reach 0$ the run is Over");
        System.out.println("But don't worry, you can just start a new game and have $100 again");
        System.out.println("");
        System.out.println("if you finished with the tutorial press a key and then hit enter");
        System.out.println("to return to the main menu");
        System.out.println("");
        input.next();
        System.out.print(ANSI_CLEAR);
      }

      else if (userInput.equals("5")) {
        System.out.print(ANSI_CLEAR);
        System.out.println(ANSI_BLUE + "Thanks for playing!" + ANSI_RESET);
        System.exit(0);

      }      
    }
  }
}
