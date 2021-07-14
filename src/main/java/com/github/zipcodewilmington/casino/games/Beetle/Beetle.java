package com.github.zipcodewilmington.casino.games.Beetle;

import com.github.zipcodewilmington.casino.models.Dice;

public class Beetle{
    private Dice dice = new Dice(1);
    private Integer currentPlayer = 0;
    private Integer[][] playerBeetles;
    private Integer[] scoreboard;
    private Integer numPlayers;

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
        this.playerBeetles[player][diceRoll]++;
        //return this.checkWinner(player);
    }

    public void refreshBeetle(Integer player){
        this.playerBeetles[player] = new Integer[] {0, 0, 0, 0, 0, 0};
    }


    public Boolean checkWinner(Integer player){
        if(this.beetleIsComplete(player)){
            this.scoreboard[player] += 6;
            if(this.getScore(player) == 30){
                return true;
            } else {
                this.refreshBeetle(player);
            }
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

    public Integer getScore(Integer player){
        return this.scoreboard[player];
    }
}
