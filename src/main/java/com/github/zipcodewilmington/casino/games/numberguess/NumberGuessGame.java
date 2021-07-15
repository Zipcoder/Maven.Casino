package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Scanner;


/**
 * Authors: Zack, Nathan
 */

public class NumberGuessGame implements GameInterface {
    private Integer maxNumber;
    private PlayerInterface currentPlayer;
    private Integer betAmount;
    private Integer multiplier;
    private Integer guessNumber;
    private int randomNumber;
    private Scanner scanner = new Scanner(System.in);

    public NumberGuessGame(){
        this.maxNumber = 20;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        //print welcome
        printWelcome();
        //print instruction for game
        System.out.println("Guess the right number between 0 and 20 to double your bets!\nFeeling lucky??\n\n Increase the difficulty and increase your earnings!");
        //print difficulty levels and ask user to choose
        setDifficultyLevel();
        //print player's current account balance
        System.out.println("Your current account balance is:   " + this.currentPlayer.getArcadeAccount().getAccountBalance());
        //ask for a bet amount
        takeBet();
        //subtract bet amount from player's account
        this.currentPlayer.getArcadeAccount().alterAccountBalance(betAmount);
        //ask player to chose number from 0 to difficulty lvl
        takeGuess();
        //generate actual number
        pickRandomNumber();
        //compare difference

        //compute winnings

        //print winnings

        //add winnings to player's account

    }

    private void pickRandomNumber() {
        this.randomNumber = (int) ((Math.random() * (maxNumber - 0)) + 0);
    }

    private void takeGuess() {
        System.out.println("Pick a number between 0 and " + maxNumber);
        this.guessNumber = scanner.nextInt();

    }

    private void takeBet() {
        System.out.println("How much do you want to bet?");
        this.betAmount = scanner.nextInt();
    }

    private void printWelcome() {
        //TODO
    }

    private void setDifficultyLevel() {
        System.out.println("1. Start max at 20 and go for double.\n" +
                "2. Change max to 30 and Triple your bets!\n" +
                "3.Change max to 40 and QUADRUPLE your bets! OH MY!\n" +
                "4.Change max to 50! SEND IT! TO THE MOON!");
        setMaxNumber(scanner.nextInt());
    }


    public Integer getGuessRange(Integer guessedNumber, Integer actualNumber){
        return guessRangePercentage(Math.abs(guessedNumber - actualNumber));
    }


    //Player can set difficulty level to get high yield
    //Take this return - reward if guess is within 10%
    //The closer to 0%, the higher reward
    //10% = money back, 8% = 1.1

    public Integer guessRangePercentage(Integer range){
        Double percent =  ((range.doubleValue() / this.maxNumber) * 100);
        return percent.intValue();
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }
    public void setMaxNumber(Integer max){
        this.maxNumber = max;
    }

    @Override
    public void add(PlayerInterface player) {
        this.currentPlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {

    }



    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return null;
    }

    @Override
    public void subtractBetFromBalance(Integer betAmount) {

    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

    }
}