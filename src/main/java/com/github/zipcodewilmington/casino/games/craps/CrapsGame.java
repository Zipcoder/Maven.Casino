package com.github.zipcodewilmington.casino.games.craps;

import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Scanner;

import static com.github.zipcodewilmington.casino.objects.Dice.roll;

//GambleableGame and GamblingPlayer
public class CrapsGame implements GambleableGame {



    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public boolean playerWins() {
        return false;
    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    @Override
    public void clearGame() {

    }


    @Override
    public void run() {
        new CrapsTable().playCraps();

    }

}








    /* Rolling two dice each time, typically presented with 5 dice
    * Player is the shooter
    * Both dice must be tossed in one throw
    * Some of these games do have rounds
    * If a shooter craps out they may keep rolling until they roll a 7 after a point has been established
    * there are at least 7 different games.craps games within games.craps
    * each game or mini game has different odds
    * the different odds will result in different pay out amounts
    * Game 1- Starting with Passline, you are betting on the outcome of a round.
    * Each round has two different phases "come out" and "point"
    * A come out roll of 2, 3, or 12 is called craps, you are crapping out and you automatically lose,
    * if you get 7 or 11 a "natural" on the first roll then you automatically win.
    * if you roll a point number such as 4, 5, 6, 8, 9, or 10 then you continue to roll
    * on subsequent rolls you must roll the point number value again before rolling a 7 to win
    * you do not need to roll a point number value in the same way
    * if you roll a 7 before your point number, you lose
    * Dealer will flip a button to "ON" and it will be on the point number, signifying the second phase of the round
    * Game 2- Don't pass, similar to game one, but when you get 2 or 3 on a come out you win, you tie if you get 12
    * -in point, if the seven comes out before the point then that Don't Pass line wins
    *
    * 2, 3, 11, or 12 do not have an affect on the pass or don't pass lines after the point has been established
    * */





