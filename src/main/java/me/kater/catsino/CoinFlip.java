package me.kater.catsino;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import static me.kater.catsino.tools.GameData.Ansi.*;
import me.kater.catsino.tools.Player;


public class CoinFlip{

    static final String[] COIN_HEAD = {
        "  ╔════════╗  ",
        " ╔╝ ▓▓██▓▓ ╚╗ ",
        "╔╝ ▓▓▓███▓▓ ╚╗",
        "║ ███HEAD███ ║",
        "╚╗ ▓▓▓███▓▓ ╔╝",
        " ╚╗ ▓▓██▓▓ ╔╝ ",
        "  ╚════════╝  "
    };
    static final String[] COIN_TAIL = {
        "  ╔════════╗  ",
        " ╔╝ ▓▓██▓▓ ╚╗ ",
        "╔╝ ▓▓▓███▓▓ ╚╗",
        "║ ███TAIL███ ║",
        "╚╗ ▓▓▓███▓▓ ╔╝",
        " ╚╗ ▓▓██▓▓ ╔╝ ",
        "  ╚════════╝  "
    };


    public static void coinFlip(Player player, Scanner scanner) {

        boolean betOnHeads = true; 

        System.out.print(ANSI_CLEAR);

        while(true) {
            System.out.print("> ");
            var input = scanner.nextLine();
            

            if (input.startsWith("coinflip ") || input.startsWith("cf ")) {
                coinFlipLogic(input, player, betOnHeads);
            }
            else if (input.equals("exit") || input.equals("quit")) {
                System.out.print(ANSI_CLEAR);
                return;
            }
            else if (input.equals("clear")) {
                System.out.print(ANSI_CLEAR);
            }
            else if (input.equals("cs") || input.equals("coinswitch")) {
                betOnHeads = !betOnHeads;
                System.out.println(ANSI_PURPLE + (betOnHeads ? "Head" : "Tail") + ANSI_RESET);
            }
            else if (input.equals("bal") || input.equals("balance")) {
                System.out.println(ANSI_GREEN + player.getBalance() + " $" + ANSI_RESET);
            }
            else if (input.equals("help")) {
                System.out.println(ANSI_PURPLE + "####################" + ANSI_RESET);
                System.out.println(ANSI_BLUE + "    Help Center    " + ANSI_RESET);
                System.out.println(ANSI_PURPLE + "####################" + ANSI_RESET);
                System.out.println(ANSI_CYAN + "- coinflip <bet> | cf <bet>  Place a bet and flip the coin" + ANSI_RESET);
                System.out.println(ANSI_CYAN + "- coinswitch | cs            Toggle current pick (Head <-> Tail)" + ANSI_RESET);
                System.out.println(ANSI_CYAN + "- clear                      Clear the screen" + ANSI_RESET);
                System.out.println(ANSI_CYAN + "- exit | quit                Return to main menu" + ANSI_RESET);
                System.out.println(ANSI_CYAN + "- bal | balance              Get Player Balance" + ANSI_RESET);
            }
            else {
                System.out.println(ANSI_RED + " Cat Shell Unknown command. Type 'help' for options." + ANSI_RESET);
            }

        }

    }

    public static void coinFlipLogic(String input, Player player, boolean betOnHeads) {
        String[] parts = input.split(" ", 3);
        double bet;
        try {
            bet = Double.parseDouble(parts[1]);
        } 
        catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid bet amount");
            return;
        }

        if (bet <= 0 || !player.withdraw(bet)) {
            System.out.println("Bet must be positive and covered");
            return;
        }
        
        boolean coinIsHeads = ThreadLocalRandom.current().nextBoolean();

        printCoin(coinIsHeads, ANSI_BLUE);

        if (coinIsHeads == betOnHeads) {
            player.deposit(bet * 2);
            System.out.println(ANSI_GREEN + "Win +" + bet + "$" + ANSI_RESET);
        }
        else {
            System.out.println(ANSI_RED + "Lose -" + bet + "$" + ANSI_RESET);
        }
        System.out.println(ANSI_YELLOW + "==========" + ANSI_RESET);
        System.out.println(ANSI_GREEN + player.getBalance() + "$" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "==========" + ANSI_RESET);
    }

    static void printCoin(boolean heads, String ansiColor) {
        String[] art = heads ? COIN_HEAD : COIN_TAIL;
        for (String line : art) {
            System.out.println(ansiColor + line + ANSI_RESET);
        }
    }
}

