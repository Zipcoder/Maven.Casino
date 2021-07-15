package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;

import java.util.Scanner;

/**
 * Created by Nathan on 7/12/21
 */
public class SlotsGame implements GameInterface{
    private Integer playerBetAmount;
    private Integer betTotal;
    private Integer loseMultiplier;
    private Integer winMultiplier;
    private PlayerInterface currentPlayer;
    private Slots slotMachine;

    public SlotsGame(){
    }

    @Override
    public void add(PlayerInterface player) {
        this.currentPlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {

    }

    public Integer getLoseMultiplier() {
        return loseMultiplier;
    }

    public Integer getWinMultiplier() {
        return winMultiplier;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        printWelcome();
        Slots newSlotMachine = new Slots();
        slotMachine = newSlotMachine;
        slotMachine.spinSlots();
        //Display first slots
        slotMachine.displaySlots();

        Boolean quitGame = false;
        while(!quitGame) {

            //print initial account balance
            System.out.println("\u001B[35mCurrent account balance:    " + currentPlayer.getArcadeAccount().getAccountBalance() + "\n");

            getBetAmount();
            Integer[] selectedBets = getBetSelections();

            //take money from player account
            currentPlayer.getArcadeAccount().alterAccountBalance(betTotal * (-1));

            slotMachine.spinSlots();
            slotMachine.displaySlots();
            slotMachine.setWinningLines();
            String[] betResults = slotMachine.compareBetVsWinningLines(selectedBets);
            this.calculateMultiplier(betResults);
            Integer winnings = calculateWinnings(this.winMultiplier, playerBetAmount);
            System.out.println("\u001B[31mYou won: " + winnings + " dollars!\n");
            //add winnings to player object
            currentPlayer.getArcadeAccount().alterAccountBalance(winnings);
            //Continue game?
            System.out.println("\u001B[36mWould you like to play again?\n" +
                    "1. Yes   2. No");
            Integer input = scanner.nextInt();
            if(input == 2){
                quitGame = true;
            }

        }
    }

    private void printWelcome() {
        System.out.println("\u001B[33m"+
                "***********************************\n" +
                "***                             ***\n" +
                "******    WELCOME TO SLOTS   ******\n" +
                "***                             ***\n" +
                "***********************************");
    }

    private void getBetAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[34m"+"How much you do want to bet?");
        Integer input = scanner.nextInt();
        playerBetAmount = input;
    }

    public Integer[] getBetSelections() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\u001B[35mHow many lines do you want to bet on?");
        Integer numberOfLines = scanner.nextInt();
        Integer totalCost = playerBetAmount * numberOfLines;
        System.out.println("\u001B[31mTotal cost to play:       " + totalCost);
        setBetTotal(totalCost);

        System.out.println(
        "\u001B[36m************************************************************************\n" +
        "**                 Select the lines you want to bet on!               **\n" +
        "**   1. Top Horizontal  2. Middle Horizontal   3. Bottom Horizontal   **\n" +
        "**   4. Left Vertical    5. Middle Vertical      6. Right Vertical    **\n" +
        "**           7. Down Diagonal              8. Up Diagonal             **\n" +
        "************************************************************************");
        Integer count = 0;
        Integer[] selectedLines = new Integer[numberOfLines];
        while (count < numberOfLines){
            System.out.println("\u001B[32mSelect your line #" + (count + 1));
            selectedLines[count] = scanner.nextInt();
            count++;
        }
        return selectedLines;
    }

    public void calculateMultiplier(String[] betResults) {
        Integer countWin = 0;
        Integer countLose = 0;
        Integer[] winVsLose = new Integer[2];
        for(String outcome: betResults){
            if(outcome == "WIN"){
                countWin++;
            } else {
                countLose++;
            }
        }
        this.winMultiplier = countWin;
        this.loseMultiplier = countLose;
    }

    public Integer calculateReturnTotal(Integer winnings, Integer losings){
          Integer returnTotal = this.betTotal + winnings - losings;
          return returnTotal;
    }

    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return multiplier * betAmount;
    }

    @Override
    public void subtractBetFromBalance(Integer losings) {
    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {
    }

    public Integer getPlayerBetAmount() {
        return playerBetAmount;
    }

    public void setPlayerBetAmount(Integer playerBetAmount) {
        this.playerBetAmount = playerBetAmount;
    }

    public Integer getBetTotal() {
        return betTotal;
    }

    public void setBetTotal(Integer betTotal) {
        this.betTotal = betTotal;
    }


    public PlayerInterface getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(PlayerInterface currentPlayer) {
        this.currentPlayer = (SlotsPlayer) currentPlayer;
    }
}
