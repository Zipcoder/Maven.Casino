package com.github.zipcodewilmington;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.Beetle.Beetle;
import com.github.zipcodewilmington.casino.games.Beetle.BeetleGame;
import com.github.zipcodewilmington.casino.games.Beetle.BeetlePlayer;
import org.junit.Assert;
import org.junit.Test;

public class BeetleGameTest {
    @Test
    public void constructorTest(){
        BeetleGame beetleGame = new BeetleGame();
        Beetle game = beetleGame.getGame();
        Boolean actual = game instanceof Beetle;

        Assert.assertTrue(actual);

    }

    @Test
    public void addTest(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);

        beetleGame.add(player);
        Boolean expected = true;
        Boolean actual = beetleGame.getPlayer() != null;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeTest(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);

        beetleGame.add(player);
        beetleGame.remove(player);
        Boolean expected = false;
        Boolean actual = beetleGame.getPlayer() != null;

        Assert.assertEquals(expected, actual);

    }

//    @Test
//    public void runTest(){
//        BeetleGame beetleGame = new BeetleGame();
//        beetleGame.setDemo(true);
//        beetleGame.run();
//        Integer actual = beetleGame.getBetAmt();
//        Integer expected = null;
//
//        Assert.assertEquals(actual, expected);
//    }
//
//    @Test
//    public void printBeetleCards(){
//        BeetleGame beetleGame = new BeetleGame();
//        String expected = "\u001B[32mYour last dice roll: 0  Your Beetle:  \n" +
//                          "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  \n" +
//                          "\u001B[32mDealer's last dice roll: 0  Dealer's Beetle:  \n" +
//                          "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  ";
//        String actual = beetleGame.printBeetleCards();
//
//
//        Assert.assertEquals(expected, actual);
//    }

    @Test
    public void isGameOverTest1(){
        BeetleGame beetleGame = new BeetleGame();
        beetleGame.setRunning(true);
        beetleGame.isGameOver(false);
        Boolean actual = beetleGame.getIsRunning();

        Assert.assertTrue(actual);
    }

    @Test
    public void isGameOverTest2(){
        BeetleGame beetleGame = new BeetleGame();
        beetleGame.setRunning(true);
        beetleGame.isGameOver(true);
        Boolean actual = beetleGame.getIsRunning();

        Assert.assertFalse(actual);
    }

    @Test
    public void determinePayout(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        beetleGame.add(player);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.setBetAmt(200);
        beetleGame.getGame().setCurrentPlayer(0);
        beetleGame.determinePayout();
        Boolean actual = player.getArcadeAccount().getAccountBalance() > 500;

        Assert.assertTrue(actual);
    }

    @Test
    public void calculateWinningsTest(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        beetleGame.add(player);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.setBetAmt(200);
        beetleGame.getGame().setCurrentPlayer(0);

        Integer actual = beetleGame.calculateWinnings(2, 200);
        Integer expected = 400;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void subtractTest(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.add(player);
        beetleGame.subtractBetFromBalance(200);
        Integer expected = 300;
        Integer actual = player.getArcadeAccount().getAccountBalance();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void addMoneyToBalance(){
        BeetleGame beetleGame = new BeetleGame();
        CasinoAccount account = new CasinoAccount("Bjork", "beeyork");
        PlayerInterface player = new Player("Bjork", account);
        player.getArcadeAccount().alterAccountBalance(500);
        beetleGame.add(player);
        beetleGame.addMoneyToBalance(player,200);
        Integer expected = 700;
        Integer actual = player.getArcadeAccount().getAccountBalance();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void printWelcomeTest(){
        BeetleGame beetleGame = new BeetleGame();

        String actual = beetleGame.printWelcome();
        String expected = "\u001B[33m***********************************\n" +
                "***                             ***\n" +
                "******   WELCOME TO BEETLE   ******\n" +
                "***                             ***\n" +
                "***********************************";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getDemoTest(){
        BeetleGame beetleGame = new BeetleGame();

        Boolean actual = beetleGame.getDemo();

        Assert.assertFalse(actual);
    }

    @Test
    public void runTest(){
        BeetleGame beetleGame = new BeetleGame();
        beetleGame.setDemo(true);
        beetleGame.run();
        Integer actual = beetleGame.getBetAmt();
        Integer expected = null;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void printBeetleCards(){
        BeetleGame beetleGame = new BeetleGame();
        String expected = "\u001B[32mYour last dice roll: 0  Your Beetle:  \n" +
                          "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  \n" +
                          "\u001B[32mDealer's last dice roll: 0  Dealer's Beetle:  \n" +
                          "\u001B[36mBody:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  ";
        String actual = beetleGame.printBeetleCards();


        Assert.assertEquals(expected, actual);
    }



}
