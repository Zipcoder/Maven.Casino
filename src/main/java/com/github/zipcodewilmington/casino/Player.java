package com.github.zipcodewilmington.casino;

public class Player{

    String name;
    Double balance;
    Double currentBet = 0.0;

    public Player(String name, Double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
    }


    public String getName() {
        return name;
    }


    public Double getBalance() {
        return balance;
    }

    private void setCurrentBet(Double currentBet) {
        this.currentBet = currentBet;
    }

    public void setBalance(Double deposit) {
        this.balance = balance + deposit;
    }


    public Double makeBet(Double betAmount) {
        currentBet = betAmount;
        balance = balance - currentBet;
        return currentBet;
    }

    private Double getCurrentBet() {
        return currentBet;
    }
}
