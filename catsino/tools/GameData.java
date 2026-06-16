package tools;

public class GameData {

  public static double money = 100.0;


  // Ansi Codes
  public static class Ansi {
    public static final String ANSI_CLEAR =  "\033[2J\033[H";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
  }


  public static void addMoney(double amount) {
    money += amount;
    money = Math.round(money * 100.0) /100.0;
  }

  public static void subtractmoney(double amount) {
    money -= amount;
    money = Math.round(money * 100.0) /100.0;
  }
}
