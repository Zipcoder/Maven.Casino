package io.zipcoder.casino.Craps;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Interfaces.GamblingGame;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Menus.CrapsMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.Utilities.Console;

import java.util.Scanner;

public class CrapsGame extends DiceGame implements Game {

    public static void main(String[] args) {
        Player player = new Player ("Jeff","Smith", 28, 300.00);
        CrapsGame crapsGame = new CrapsGame(10.00,50.00,player);
        crapsGame.startPlay();
    }

    private String name = "Craps";
    private double minBet;
    private double maxBet;
    private CrapsPlayer player;
    private Integer setThePointRoll;    //saves your first roll to try to match with later rolls
    private Integer currentRoll;        //any roll after the first
    private Integer numRolls = 0;
    private Integer counter=1;
    private Console console = new Console(System.in, System.out);
    private GameServices gameServices = new GameServices();



    //Craps Game Constructor
    public CrapsGame(double minBet, double maxBet, Player incomingPlayer) {
        this.minBet = minBet;
        this.maxBet = maxBet;
        this.player = new CrapsPlayer(incomingPlayer);
    }

    public String getName() {
        return name;
    }

    @Override
    //creates dice and runs a roundOfPlay
    public void startPlay() {
        new CrapsMenu(this).displayMenu();
        roundOfPlay();
        endChoice();
    }

    @Override
    //runs a new game of craps
    public void roundOfPlay() {
        Double betSize = betChoice();
        userRollsDiceSetPoint();
        if (winOnFirst(setThePointRoll) == true) {
            winningMessageFirstRoll();
            calculateWinnings(betSize, setThePointRoll, numRolls);
        } else if (loseOnFirst(setThePointRoll) == true) {
            losingMessageFirstRoll();
        } else {
            displayPointRoll(setThePointRoll);
            for (int i = 0; i < 3; i++) {
                userRollsDiceCurrentPoint();
                displayCurrentRoll(currentRoll);
                if (winOnSubsequent(currentRoll, setThePointRoll) == true) {
                    winOnSubsequentMessage();
                    calculateWinnings(betSize, setThePointRoll, numRolls);
                    break;
                } else if (loseOnSubsequent(currentRoll) == true) {
                    loseOnSubsequentMessage();
                    break;
                }
                if (i == 2) {
                    losingMessageOutOfRolls();
                }
                numRolls = i + 1;
            }
        }
    }

    public Double betChoice(){
        Double wager;
        console.println(String.format("\n[CROUPIER]: Current bankroll: $%.2f", this.player.getPlayer().getBalance()));
        wager = console.getCurrency(String.format("[CROUPIER]: The limits here are %.2f and %.2f\n[CROUPIER]: Bet size (press Enter to stand up): ", this.minBet, this.maxBet));

         if (wager > this.player.getPlayer().getBalance()){
            console.println(String.format("\n[CROUPIER]: Your mouth is writing checks that your wallet can't cash, %s.", this.player.getPlayer().getLastName()));
            betChoice();
        }
        else if (wager < this.minBet || wager > this.maxBet) {
            console.println("\n[CROUPIER]: You're not playing within the table limits, %s.", this.player.getPlayer().getLastName());
            betChoice();
        }
        else if (wager != null) {
             gameServices.wager(wager, this.player.getPlayer());
            return wager;
        }
        return wager;
    }

    public Double calculateWinnings(Double wager, Integer setThePointRoll, Integer numRolls){
        // PUT THE PAY TABLE HERE
        if (setThePointRoll == 7 || setThePointRoll == 11){
            gameServices.payOut(2 * wager, this.player.getPlayer());
            return 2 * wager;
        }
        else if (setThePointRoll == 4 || setThePointRoll == 10){
            gameServices.payOut((7 - numRolls) * wager, this.player.getPlayer());
            return (7 - numRolls) * wager;
            }
        else if (setThePointRoll == 5 || setThePointRoll == 9){
            gameServices.payOut((6 - numRolls) * wager, this.player.getPlayer());
            return (6 - numRolls) * wager;
        }
        else if (setThePointRoll == 6 || setThePointRoll == 8){
            gameServices.payOut((5 - numRolls) * wager, this.player.getPlayer());
            return (5 - numRolls) * wager;
        }
        return 0.0;
    }

    @Override
    //implements menu whether you want to quit or go again
    public void endChoice() {
        String endChoiceInput = console.getInput("You have finished this game of Craps.\nWould you like to play again? (Y/N)\n");
        if (endChoiceInput.toUpperCase().equals("N")) {
            console.println("Have a good rest of your day.");
        } else if (endChoiceInput.toUpperCase().equals("Y")) {
            console.println("That's great!!!");
            startPlay();
        } else {
            console.println("That's not a valid selection. Please choose again.");
            endChoice();
        }
    }

    public boolean winOnFirst(Integer setThePointRoll) {
        if (setThePointRoll == 7 || setThePointRoll == 11) {
            return true;
        } else {
            return false;
        }
    }

    public boolean loseOnFirst(Integer setThePointRoll) {
        if (setThePointRoll == 2 || setThePointRoll == 3 || setThePointRoll == 12) {
            return true;
        } else {
            return false;
        }
    }


    public boolean winOnSubsequent(Integer currentRoll, Integer setThePointRoll) {
        if (currentRoll.equals(setThePointRoll)) {
            return true;
        }
        return false;
    }

    public boolean loseOnSubsequent(Integer currentRoll) {
        if (currentRoll == 7) {
            return true;
        }
        return false;
    }

    public Integer calculatePayoutMultiplier() {
        //catch statements
        return null;
    }

    public void userRollsDiceSetPoint() {
        console.getInput("\nPress Enter to roll the dice\n");
        tossPointRoll();
        counter++;
    }

    public void userRollsDiceCurrentPoint() {
        console.getInput(String.format("-------------------------------------------------\nSet the Point Roll: %d\nPress Enter to roll the dice\n", setThePointRoll));
        tossCurrentRoll();
    }

    public Integer tossPointRoll() {
        setThePointRoll = DiceGame.roll(2);
        return setThePointRoll;
    }

    public void displayPointRoll(Integer setThePointRoll) {
        console.println(String.format("You have rolled a %d for your set the point roll.", setThePointRoll));
    }

    public void displayCurrentRoll(Integer currentRoll) {
        console.println(String.format("You have rolled a %d for this roll.", currentRoll));
    }

    public void winningMessageFirstRoll() {
        console.println(String.format("You rolled a %d on the first roll!\nCongratulations!!\nYou are a winner!!!\n------------------------------------------\n\n", setThePointRoll));
    }

    public void losingMessageFirstRoll() {
        console.println(String.format("You rolled a %d and have lost on the first roll!\nThis is unfortunate.....\n:(\n-------------------------------------------\n\n", setThePointRoll));
    }

    public void losingMessageOutOfRolls() {
        console.println(String.format("You are out of rolls.\nYou seem to have lost.\nThis is unfortunate.....\n:(\n-----------------------------------------\n\n"));
    }

    public Integer tossCurrentRoll() {
        currentRoll = DiceGame.roll(2);
        return currentRoll;
    }


    public void winOnSubsequentMessage () {
        console.println(String.format("Hooray! You rolled a %d, and you have won!!  It took you %d rolls to win.", currentRoll, counter));
        counter = 0;
    }

    public void loseOnSubsequentMessage () {
        console.println(String.format("It appears that the odds were not in your favor today.\nBetter luck next time.....\n-----------------------------------------------\n\n"));
    }
}


