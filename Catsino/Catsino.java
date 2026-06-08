import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Catsino {

    // Ansi Color's and Clear
    public static final String ANSI_CLEAR = "\033[2J\033[H";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";

    // Game Value
    public static double money = 100;

    // Importan Stuff
    public static Scanner input = new Scanner(System.in);
    public static DecimalFormat decimalFormat = new DecimalFormat("#.####");

    public static void main(String[] args) {

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

            switch (input.nextInt()) {

                case 1:

                    numberGuess();

                    break;

                case 2:
                    // Save System
                    saveSystem.save(money);
                    System.out.println(ANSI_GREEN + "Game Saved" + ANSI_CLEAR);
                    System.out.print(ANSI_CLEAR);

                    break;

                case 3:
                    money = saveSystem.load();
                    System.out.print(ANSI_CLEAR);
                    break;

                case 4:
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
                    break;

                case 5:
                    System.out.print(ANSI_CLEAR);
                    System.out.println(ANSI_BLUE + "Thanks for playing!" + ANSI_RESET);
                    System.exit(0);

                    break;

            }
        }
    }

    public static void numberGuess() {

        double bet;
        int guess;

        System.out.print(ANSI_CLEAR);

        // number guess Game
        int randomNumber = new Random().nextInt(3) + 1;
        System.out.println(ANSI_GREEN + "This is your balanc: " + money + "$" + ANSI_RESET);
        System.out.print("Please enter your bet: ");
        bet = input.nextDouble();

        if (bet == 13_15_14_5_25) { // money cheat code

            System.out.println("How much Money you want to add");
            System.out.print(">");

            int cheatMoney = input.nextInt();
            money += cheatMoney;

            return;
        } else if (bet > money) {

            System.out.println("you dont have enough money!");
            System.out.println("");
            return;

        } else {
            money -= bet;
            System.out.println("you cane choice a number between 1 and 3");
            System.out.print("Please enter your guess: ");
            guess = input.nextInt();

            if (guess == randomNumber) {
                System.out.println("Your guess is correct!");
                decimalFormat.format(bet += 0.5 * bet); //bet += 0.5* bet;
                money += bet;
                bet -= bet;
            } else {
                System.out.println("Your guess is incorrect!");
                bet -= bet;
                System.out.println("");
            }
        }

    }
}
