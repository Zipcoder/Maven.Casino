package com.github.zipcodewilmington.casino.games.numberguess;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Scanner;


/**
 * Created by Nathan on 7/14/2021
 */

public class NumberGuessGame implements GameInterface {
    private final IOConsole consoleR = new IOConsole(AnsiColor.RED);
    private final IOConsole consoleG = new IOConsole(AnsiColor.GREEN);
    private final IOConsole consoleY = new IOConsole(AnsiColor.YELLOW);
    private final IOConsole consoleB = new IOConsole(AnsiColor.BLUE);
    private final IOConsole consoleP = new IOConsole(AnsiColor.PURPLE);
    private final IOConsole consoleC = new IOConsole(AnsiColor.CYAN);
    private Integer maxNumber;
    private PlayerInterface currentPlayer;
    private Integer betAmount;
    private Integer multiplier;
    private Integer guessNumber;
    private int randomNumber;
    private Scanner scanner = new Scanner(System.in);
    private Integer[] potentialEarnings = new Integer[4];

    public NumberGuessGame(){
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        printWelcome();
        Boolean quitGame = false;
        while(!quitGame) {
            //print instruction for game
            printInstructions();
            //print player's current account balance
            consoleG.println("Your current account balance is:   $" + this.currentPlayer.getArcadeAccount().getAccountBalance() + "\n");
            //ask for a bet amount
            takeBet();
            //subtract bet amount from player's account
            subtractBetFromBalance(betAmount);
            calcPotentialEarnings();
            consoleR.println("You bet:  $"+betAmount+ "\n\nBut WAIT!\nFeeling lucky??\nIncrease the difficulty and increase your earnings!\n");
            //print difficulty levels and ask user to choose
            setDifficultyLevel();
            setMultiplier(maxNumber);
            //ask player to chose number from 0 to difficulty lvl
            takeGuess();
            //generate actual number
            pickRandomNumber();
            //compare difference
            Integer guessRange = getGuessRange(guessNumber, randomNumber);
            printGuessVsActual();
            //calculate amount player won
            Integer payout = calculatePayout(multiplier, guessRange, betAmount);
            //print winnings
            consoleR.println("You won:   $"+payout);
            //add winnings to player's account
            addMoneyToBalance(currentPlayer,payout);
            //ask if player wants to play again
            consoleC.println("\u001B[36m\nWould you like to play again?\n" +
                    "1. Yes   2. No");
            Integer input = scanner.nextInt();
            if(input == 2){
                quitGame = true;
            }
        }
    }

    private void printGuessVsActual() {
        consoleG.println("Lets compare results!");
        consoleY.println("You guessed: " + guessNumber);
        consoleY.println("Actual Number: " + randomNumber);
    }

    private void printInstructions() {
        consoleB.println("Guess a number between 0 and 20.\n" +
                "Guess close enough and win a prize!\n" +
                "Pick the right number to double your bets!\n");
    }

    private Integer calculatePayout(Integer multiplier, Integer guessRange,Integer betAmount) {
        Integer payout;
        Double percent = 0.0;
        Double multiplierAsDouble = multiplier.doubleValue();
        if (guessRange.equals(0)){
            percent = multiplierAsDouble * 1;
        } else if(guessRange <= 10){
            percent = multiplierAsDouble * 0.8;
        } else if(guessRange <= 25){
            percent = multiplierAsDouble * 0.6;
        } else if(guessRange <= 35){
            percent = multiplierAsDouble * 0.4;
        } else if(guessRange >= 36){
            percent = multiplierAsDouble * 0.0;
        }
        Double payoutAsDouble = percent * betAmount;
        payout = payoutAsDouble.intValue();
        return payout;
    }

    private void pickRandomNumber() {
        Integer random = (int) ((Math.random() * (maxNumber - 0)) + 0);
        this.randomNumber = random;

    }

    private void takeGuess() {
        consoleP.println("Pick a number between 0 and " + maxNumber);
        this.guessNumber = scanner.nextInt();

    }

    private void takeBet() {
        consoleB.println("How much do you want to bet?");
        this.betAmount = scanner.nextInt();
    }

    private void printWelcome() {
        consoleY.println(
                "************************************\n" +
                "***                              ***\n" +
                "******   !!  WELCOME TO  !!   ******\n" +
                "******  !!! GUESS NUMBER !!!  ******\n" +
                "***                              ***\n" +
                "************************************\n");
    }

    private void calcPotentialEarnings(){
        Integer[] calcPotentialEarnings = new Integer[4];
        for (int i = 0; i < 4; i++) {
            calcPotentialEarnings[i] = betAmount * (i + 2);
        }
        this.potentialEarnings = calcPotentialEarnings;
    }

    private void setDifficultyLevel() {
        consoleC.println(
                "1. Start max at 20 and win up to " + potentialEarnings[0] + "!\n" +
                "2. Change max to 30 and Triple your winnings up to " + potentialEarnings[1] + "!\n"+
                "3. Change max to 40 and QUADRUPLE your winnings up to " + potentialEarnings[2] + "!\n"+
                "4. Change max to 50! SEND IT TO THE MOON AND WIN UP TO " + potentialEarnings[3] + "!\n");
        Integer input = scanner.nextInt();
        switch (input){
            case 1:
                setMaxNumber(20);
                break;
            case 2:
                setMaxNumber(30);
                break;
            case 3:
                setMaxNumber(40);
                break;
            case 4:
                setMaxNumber(50);
                break;
        }
    }

    public Integer getGuessRange(Integer guessedNumber, Integer actualNumber){
        return guessRangePercentage(Math.abs(guessedNumber - actualNumber));
    }

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

    public void setMultiplier(Integer difficultyLvl) {
        switch(difficultyLvl){
            case 20:
                this.multiplier = 2;
                break;
            case 30:
                this.multiplier = 3;
                break;
            case 40:
                this.multiplier = 4;
                break;
            case 50:
                this.multiplier = 5;
                break;
        }
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
        this.currentPlayer.getArcadeAccount().alterAccountBalance((betAmount * -1));
    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {
        Player.getArcadeAccount().alterAccountBalance(winnings);
    }
}