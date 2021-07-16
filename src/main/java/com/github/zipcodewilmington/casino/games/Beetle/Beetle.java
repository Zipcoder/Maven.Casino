package com.github.zipcodewilmington.casino.games.Beetle;

import com.github.zipcodewilmington.casino.models.Dice;

public class Beetle{
    private Dice dice = new Dice(1);
    private Integer currentPlayer = 0;
    private Integer[][] playerBeetles;
    private Integer[] scoreboard;
    private Integer numPlayers;
    private Integer lastDiceRolls[] = {0, 0};


    public Beetle(Integer numPlayers){
        this.numPlayers = numPlayers;
        this.playerBeetles = new Integer[numPlayers][6];
        this.scoreboard = new Integer[numPlayers];
        this.initializeBeetleCards();
        this.initializeScoreboards();
    }

    public void initializeBeetleCards(){
        for(int i = 0; i < numPlayers; i++){
            for(int j = 0; j < 6; j++){
                this.playerBeetles[i][j] = 0;
            }
        }
    }

    public void initializeScoreboards(){
        for(int i = 0; i < numPlayers; i++){
            this.scoreboard[i] = 0;
        }
    }

    public Dice getDice() {
        return dice;
    }

    public Integer getCurrentPlayer() {
        return currentPlayer;
    }

    public Integer[][] getPlayerBeetles() {
        return playerBeetles;
    }

    public Integer getNumPlayers() {
        return numPlayers;
    }

    public Integer[] getPlayerCard(Integer playerNumber){
        return this.getPlayerBeetles()[playerNumber];
    }

    public void setCurrentPlayer(Integer currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setPlayerBeetles(Integer player, Integer diceRoll) {
        this.playerBeetles[player][diceRoll - dice.getNumDice()]++;
        this.lastDiceRolls[player] = diceRoll;
    }

    public void nextPlayer(){
        this.currentPlayer = (this.currentPlayer + 1) % this.numPlayers;
    }

    public String printBeetle(Integer player){
        Integer[] currentBeetle = this.getPlayerBeetles()[player];
        String output = "\u001B[36mBody:";
        output += (currentBeetle[0].equals(0)) ? "0  " : "X  ";
        output += "Head:";
        output += (currentBeetle[1].equals(0)) ? "0  " : "X  ";
        output += "Legs:";
        output += (currentBeetle[2].equals(0)) ? "0  " : "X  ";
        output += "Eyes:";
        output += (currentBeetle[3].equals(0)) ? "0  " : "X  ";
        output += "Antenna:";
        output += (currentBeetle[4].equals(0)) ? "0  " : "X  ";
        output += "Tail:";
        output += (currentBeetle[5].equals(0)) ? "0  " : "X  ";

        return output;
    }

    public Boolean checkWinner(Integer player){
        if(this.beetleIsComplete(player)){
            return true;
        }
        return false;
    }

    public Boolean beetleIsComplete(Integer player){
        Integer[] playerBeetle = getPlayerCard(player);
        for(int i = 0; i < 6; i++){
            if(playerBeetle[i] == 0)
                return false;
        }
        return true;
    }

    public Integer getLastDiceRoll(Integer index){
        return this.lastDiceRolls[index];
    }

    public Integer getScore(Integer player){
        return this.scoreboard[player];
    }
}
