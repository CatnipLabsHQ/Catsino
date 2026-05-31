import java.util.Random;
import java.util.Scanner;

public class Catsino {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int money = 100;
        int bet;
        int guess;


        while (true){

            // Introduction
            System.out.println("Welcome to Catsino!");
            System.out.println("[1] Start Playing");
            System.out.println("[2] Tutorial");
            System.out.println("[3] Exit");
            System.out.print("What is your choice: ");


            switch (input.nextInt()){
                case 1:
                    // Game
                    int randomNumber = new Random().nextInt(3) + 1;
                    System.out.println("");
                    System.out.println("This is your balanc: " + money + "$");
                    System.out.print("Please enter your bet: ");
                    bet = input.nextInt();

                    if(bet > money){
                        System.out.println("you dont have enough money!");
                        System.out.println("");
                        break;
                    }
                    else{
                        money -= bet;
                        System.out.println("you cane choice a number between 1 and 3");
                        System.out.print("Please enter your guess: ");
                        guess = input.nextInt();

                        if(guess == randomNumber){
                            System.out.println("Your guess is correct!");
                            bet += 0.5* bet;
                            money += bet;
                            bet -= bet;
                        }
                        else{
                            System.out.println("Your guess is incorrect!");
                            bet -= bet;
                            System.out.println("");
                        }
                    }
                    break;

                case 2:
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
                    break;

                case 3:
                    System.out.println("");
                    System.out.println("Thanks for playing!");
                    System.exit(0);
            }
        }
    }
}
