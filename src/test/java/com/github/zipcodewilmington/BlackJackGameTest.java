package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJack;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BlackJackGameTest {

    @Test
    public void runTest () {
        //Player player = new Player("Roger", 5000);
    }
    public void startGameTest () {
        BlackJack bj = new BlackJack();
        BlackJackGame blackJackGame = new BlackJackGame();


        Integer choice = 2;
    }

    @Test
    public void calculateWinningsTest () {
        BlackJackGame blackJack = new BlackJackGame();
        Integer expected = 12;

        Integer multiplier = 3;
        Integer betAmount = 4;
        Integer actual = blackJack.calculateWinnings(multiplier, betAmount);

        Assert.assertEquals(expected,actual);
    }

//    @Test
//    public void subtractFromBalance () {
//        BlackJackGame blackJack = new BlackJackGame();
//        Player player = new Player("Steve", 100);
//        Integer expected = 60;
//
//        Integer bet = 40;
//        blackJack.subtractBetFromBalance(bet);
//        Integer actual = player.getBalance();
//
//        Assert.assertEquals(expected, actual);
//    }


    @Test
    public void splitPlayerHitsBlackJack () {
        
    }
}
