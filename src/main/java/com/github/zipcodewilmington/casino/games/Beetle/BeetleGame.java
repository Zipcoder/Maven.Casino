package com.github.zipcodewilmington.casino.games.Beetle;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;

public class BeetleGame implements GameInterface {
    private Beetle game;
    private Boolean isRunning = false;
    private PlayerInterface player;
    private IOConsole console = new IOConsole();
    private Integer betAmt;
    private Boolean isDemo = false;

    public BeetleGame(){
        this.game = new Beetle(2);
    }

    public void add(PlayerInterface player){
        this.player = player;
    }

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    public void remove(PlayerInterface player){
        this.player = null;
    }

    /**
     * specifies how the game will run
     */
    public void run(){
        if(isDemo) return;
        this.initGame();
        while(this.isRunning){
            this.nextPlayer();
            this.executeTurn();
            this.isGameOver(this.game.checkWinner(this.game.getCurrentPlayer()));
        }
        this.printEndingGameMessage();
    }

    public void initGame(){
        console.println(printWelcome());
        console.newLine();
        this.setBetAmt(printBalanceAndBetText());
        Integer turnCount = 0;
        game.setCurrentPlayer(-1);
        this.isRunning = true;
    }

    public String printBeetleCards(){
        String output = "";
        output += "\u001B[32mYour last dice roll: " + game.getLastDiceRoll(0) +
                  "  Your Beetle:  \n";
        output += game.printBeetle(0) +"\n";
        output += "\u001B[32mDealer's last dice roll: " + game.getLastDiceRoll(1) +
                "  Dealer's Beetle:  \n";
        output += game.printBeetle(1);
        return output;
    }

    public void isGameOver(boolean playerWon){
        if(playerWon){
            isRunning = false;
        }
    }
    public void nextPlayer(){
        game.nextPlayer();
    }

    public void executeTurn(){
        Integer currentPlayer = game.getCurrentPlayer();
        if(game.getCurrentPlayer() == 0){
            console.println(this.printBeetleCards());
            console.println("Press enter to roll next dice");
            console.pressEnterToProceed();
        }
        game.setPlayerBeetles(currentPlayer, game.getDice().tossAndSum());
    }

    public Integer determinePayout(){
        Integer payout = (int)(this.betAmt * 1.1);
        if(this.game.getCurrentPlayer() == 0){
            this.player.getArcadeAccount().alterAccountBalance(payout);
            return payout;
        }
        return 0;
    }
    /**
     * Calculate player's winning payout amount of bet x multiplier
     * @return (double) amount of money winnings
     */
    public Integer calculateWinnings(Integer multiplier, Integer betAmount){
        return multiplier * betAmount;
    }

    /**
     * Subtract the bet amount from player's balance
     */
    public void subtractBetFromBalance(Integer betAmount){
        player.getArcadeAccount().alterAccountBalance(betAmount * -1);
    }


    /**
     * Add winnings amount to player's balance
     */
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings){
        Player.getArcadeAccount().alterAccountBalance(winnings);
    }



    public String printWelcome() {
        return
                "\u001B[33m***********************************\n" +
                        "***                             ***\n" +
                        "******   WELCOME TO BEETLE   ******\n" +
                        "***                             ***\n" +
                        "***********************************";
    }


    public Integer printBalanceAndBetText(){
        console.newLine();
        console.println("\u001B[35m Current account balance:        " + this.player.getArcadeAccount().getAccountBalance());
        console.newLine();
        return console.getIntegerInput("\u001B[34m How much do you want to bet?");
    }

    public void printWinnerMessage(){
        if(this.game.getCurrentPlayer() == 0){
            console.println("You win!");
        } else {
            console.println("Dealer wins...");
        }
        console.newLine();
    }

    public void printEndingGameMessage(){

        /*
        console.newLine();
        console.println("Final Beetle results: ");
        this.printBeetleCards();
        console.newLine();
        this.printWinnerMessage();
        console.println("Your payout is: " + this.determinePayout().toString());
        console.pressEnterToProceed();
         */
    }

    public Beetle getGame() {
        return game;
    }

    public Boolean getDemo() {
        return isDemo;
    }

    public void setDemo(Boolean demo) {
        isDemo = demo;
    }

    public PlayerInterface getPlayer() {
        return player;
    }

    public Boolean getIsRunning(){
        return this.isRunning;
    }

    public Integer getBetAmt() {
        return betAmt;
    }

    public void setBetAmt(Integer betAmt) {
        this.betAmt = betAmt;
    }

    public void setRunning(boolean running){
        this.isRunning = running;
    }
}
