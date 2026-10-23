package com.catsino.tools;

public class Player{

  private double money;

  private void round() {
    this.money = Math.round(this.money * 100.0) / 100.0;
  }


  public Player(double startMoney) {
    this.money = startMoney;
  }

  public boolean deposit(double amount) {

    if (amount <= 0) {
      return false;
    }
    this.money += amount;
    round();
    return true;
  }

  public boolean withdraw(double amount) {
    // if money is lower or the withdraw is higher then the balance return false
    if (amount <= 0 || amount > this.money) {
      return false;
    }
    this.money -= amount;
    round();
    return true;
  }

  public double getBalance() {
    return money;
  }

  public boolean restore(double savedBalance) {
    if (savedBalance < 0 || !Double.isFinite(savedBalance)) {
      return false;
    }
    this.money = savedBalance;
    return true;
  }
}
