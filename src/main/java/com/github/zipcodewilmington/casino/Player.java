package com.github.zipcodewilmington.casino;

public class Player implements PlayerInterface{
    //retains the information about player including balance once game is over


     String name;
     String password;
     float balance;
     float currentBet;

     public Player(String name, String password, float balance, float currentBet) {
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.currentBet = currentBet;
    }

    public  Player (String name, String password){
         this.name = name;
         this.password = password;
         this.balance = 0;
         this.currentBet = 0;
    }


    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public float getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(float currentBet) {
        this.currentBet = currentBet;
    }




}
