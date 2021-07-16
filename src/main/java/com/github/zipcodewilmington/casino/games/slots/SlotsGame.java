package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Scanner;

/**
 * Created by Nathan on 7/12/21
 */
public class SlotsGame implements GameInterface{
    private final IOConsole Red = new IOConsole(AnsiColor.RED);
    private final IOConsole Green = new IOConsole(AnsiColor.GREEN);
    private final IOConsole Yellow = new IOConsole(AnsiColor.YELLOW);
    private final IOConsole Blue = new IOConsole(AnsiColor.BLUE);
    private final IOConsole Purple = new IOConsole(AnsiColor.PURPLE);
    private final IOConsole Cyan = new IOConsole(AnsiColor.CYAN);
    private IOConsole input = new IOConsole();
    private Integer playerBetAmount;
    private Integer betTotal;
    private Integer loseMultiplier;
    private Integer winMultiplier;
    private PlayerInterface currentPlayer;

    public SlotsGame(){
    }

    @Override
    public void add(PlayerInterface player) {
        this.currentPlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.currentPlayer = null;
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
        Slots slotMachine = new Slots();
        slotMachine.spinSlots();
        //Display first slots
        slotMachine.displaySlots();

        boolean quitGame = false;
        while(!quitGame) {

            //print initial account balance
            Green.println("Current account balance:    $" + currentPlayer.getArcadeAccount().getAccountBalance() + "\n");

            getBetAmount();
            Integer[] selectedBets = getBetSelections();

            //take money from player account
            subtractBetFromBalance(betTotal);

            slotMachine.spinSlots();
            slotMachine.displaySlots();
            slotMachine.setWinningLines();
            String[] betResults = slotMachine.compareBetVsWinningLines(selectedBets);
            this.calculateMultiplier(betResults);
            Integer winnings = calculateWinnings(this.winMultiplier, playerBetAmount);
            Red.println("You won: " + winnings + " dollars!\n");
            //add winnings to player object
            addMoneyToBalance(currentPlayer, winnings);
            //show current balance
            Green.println("Current Account Balance:    $" + currentPlayer.getArcadeAccount().getAccountBalance());
            //Continue game?
            Integer userInput = input.getIntegerInput("Would you like to play again?\n" +
                    "1. Yes   2. No");
            if(userInput.equals(2)){
                quitGame = true;
            }

        }
    }

    public void printWelcome() {
        Yellow.println(
                "***********************************\n" +
                "***                             ***\n" +
                "******    WELCOME TO SLOTS   ******\n" +
                "***                             ***\n" +
                "***********************************");
    }

    public void getBetAmount() {
        Scanner scanner = new Scanner(System.in);
        Purple.println("How much you do want to bet?");
        playerBetAmount = scanner.nextInt();
    }

    public Integer[] getBetSelections() {
        Scanner scanner = new Scanner(System.in);
        Blue.println("How many lines do you want to bet on?");
        Integer numberOfLines = scanner.nextInt();
        Integer totalCost = playerBetAmount * numberOfLines;
        Red.println("Total cost to play:       " + totalCost);
        setBetTotal(totalCost);

        Cyan.println(
        "************************************************************************\n" +
        "**                 Select the lines you want to bet on!               **\n" +
        "**   1. Top Horizontal  2. Middle Horizontal   3. Bottom Horizontal   **\n" +
        "**   4. Left Vertical    5. Middle Vertical      6. Right Vertical    **\n" +
        "**           7. Down Diagonal              8. Up Diagonal             **\n" +
        "************************************************************************");
        int count = 0;
        Integer[] selectedLines = new Integer[numberOfLines];
        while (count < numberOfLines){
            Blue.println("Select your line #" + (count + 1));
            selectedLines[count] = scanner.nextInt();
            count++;
        }
        return selectedLines;
    }

    public void calculateMultiplier(String[] betResults) {
        int countWin = 0;
        int countLose = 0;
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
        return this.betTotal + winnings - losings;
    }

    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return multiplier * betAmount;
    }

    @Override
    public void subtractBetFromBalance(Integer losings) {
        currentPlayer.getArcadeAccount().alterAccountBalance(losings * (-1));
    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {
        Player.getArcadeAccount().alterAccountBalance(winnings);
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

}
