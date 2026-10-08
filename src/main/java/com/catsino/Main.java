package com.catsino;

import java.util.Scanner;

import com.catsino.tools.Player;

public class Main {

  public static void main(String[] args) {

    Player player = new Player(100.0);
    Scanner scanner = new Scanner(System.in);
    Catsino.menu(player, scanner); 
  }
}
