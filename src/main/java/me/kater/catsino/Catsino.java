package me.kater.catsino;

import java.util.Scanner;

import static me.kater.catsino.tools.GameData.Ansi.*;
import me.kater.catsino.tools.Player;

public class Catsino {

    public static void menu(Player player, Scanner scanner) {

        try {
            Startup.startupMain();
        } 
        catch (InterruptedException e) {}

        // clear's Terminal Screen
        System.out.print(ANSI_CLEAR);

        while (true) {
            // Introduction
            System.out.println(ANSI_PURPLE + "Welcome to Catsino!" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "Your Balance: " + player.getBalance() + "$" + ANSI_RESET);
            System.out.println("[1] Start Playing");
            System.out.println("[2] Save");
            System.out.println("[3] Load");
            System.out.println("[4] Tutorial");
            System.out.println("[5] Exit");
            System.out.println("[6] coinflip");
            System.out.print("What is your choice: ");

            String userInput = scanner.nextLine();

            switch (userInput.toLowerCase()) {
                case "1", "play"                -> {clearScreen(); NumberGuess.numberGuess(player, scanner);}
                case "2", "save"                -> saveGame(player, scanner);
                case "3", "load"                -> loadGame(player, scanner);
                case "4", "tutorial"            -> tutorial(scanner);
                case "5", "quit", "exit", "q"   -> {clearScreen(); System.out.println(ANSI_BLUE + "Thanks for playing!" + ANSI_RESET); System.exit(0);}
                case "6", "cf", "coinflip"      -> CoinFlip.coinFlip(player, scanner);
                case "catmode"                  -> CatMode.catMode(player, scanner);

                default -> clearScreen();
            }
        }
    }

    private static void clearScreen() {
        System.out.print(ANSI_CLEAR);
    }

    private static void saveGame(Player player, Scanner scanner){
        // Save System
        System.out.print(ANSI_CLEAR);
        System.out.print("Save Game? (y/n) \n> ");

        String answer = scanner.nextLine().trim().toLowerCase();

        if (answer.equals("y")) {
            SaveSystem.save(player.getBalance());
            System.out.print(ANSI_CLEAR);
            System.out.println(ANSI_GREEN + "Game Save" + ANSI_RESET);
        } 
        else {
            System.out.print(ANSI_CLEAR);
            System.out.println(ANSI_RED + "Save Canceled" + ANSI_RESET);
        }
    }

    private static void loadGame(Player player, Scanner scanner) {

        // Load System
        System.out.print(ANSI_CLEAR);
        System.out.print("Load Game (y/n) \n> ");

        String answer = scanner.nextLine().trim().toLowerCase();

        if (answer.equals("y")) {
            double loaded = SaveSystem.load();
            if (!player.restore(loaded)) {
                System.out.println(ANSI_RED + "Save-File Error" + ANSI_RESET);
            }
            System.out.print(ANSI_CLEAR);
            System.out.println(ANSI_GREEN + "Load Game" + ANSI_RESET);
        } 
        else {
            System.out.print(ANSI_CLEAR);
            System.out.println(ANSI_GREEN + "Load Canceled" + ANSI_RESET);
        }

    }

    private static void tutorial(Scanner scanner) {
            // Tutorial
            System.out.print(ANSI_CLEAR);
            System.out.println("Tutorial coming soon...");

            scanner.nextLine();
            System.out.print(ANSI_CLEAR);

    }
}
