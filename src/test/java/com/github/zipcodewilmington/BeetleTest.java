package com.github.zipcodewilmington;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.zipcodewilmington.casino.games.Beetle.Beetle;
import org.junit.Assert;
import org.junit.Test;

public class BeetleTest {
    @Test
    public void constructorTest1(){
        Beetle beetle = new Beetle(3);
        Integer expected = 3;
        Integer actual = beetle.getPlayerBeetles().length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTest2(){
        Beetle beetle = new Beetle(2);
        Integer expected = 6;
        Integer[][] playerCards = beetle.getPlayerBeetles();
        Integer actual = playerCards[0].length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTest3(){
        Beetle beetle = new Beetle(4);
        Integer expected = 0;
        Integer[][] playerCards = beetle.getPlayerBeetles();
        Integer actual = playerCards[0][0];

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void constructorTest4(){
        Beetle beetle = new Beetle(2);
        Integer expected = 0;
        Integer actual = beetle.getScore(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numPlayersTest(){
        Beetle beetle = new Beetle(2);
        Integer expected = 2;
        Integer actual = beetle.getNumPlayers();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPlayerTest(){
        Beetle beetle = new Beetle(2);
        Integer expected = 1;
        beetle.setCurrentPlayer(1);
        Integer actual = beetle.getCurrentPlayer();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setPlayerBeetleTest(){
        Beetle beetle = new Beetle(2);
        Integer expected = 1;
        beetle.setPlayerBeetles(0, beetle.getDice().tossAndSum());
        Integer actual = 0;
        Integer[] playerCard = beetle.getPlayerCard(0);
        for(int i = 0; i < 6; i++){
            if(playerCard[i] > 0){
                actual++;
            }
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void beetleIsCompleteTest1(){
        Beetle beetle = new Beetle(2);
        Boolean expected = true;
        for(int i = 1; i <= 6; i++) {
            beetle.setPlayerBeetles(0, i);
        }
        Boolean actual = beetle.beetleIsComplete(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void beetleIsCompleteTest2(){
        Beetle beetle = new Beetle(2);
        Boolean expected = false;
        Boolean actual = beetle.beetleIsComplete(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkWinnerTest1(){
        Beetle beetle = new Beetle(2);
        Boolean actual = false;
            for(int j = 1; j <= 6; j++){
                beetle.setPlayerBeetles(0, j);
            }
            actual = beetle.checkWinner(0);
        Assert.assertTrue(actual);
    }

    @Test
    public void checkWinnerTest2(){
        Beetle beetle = new Beetle(2);
        Boolean actual = false;
            for(int j = 1; j <= 5; j++){
                beetle.setPlayerBeetles(0, j);
            }
            actual = beetle.checkWinner(0);
        Assert.assertFalse(actual);
    }

    @Test
    public void nextPlayerTest1(){
        Beetle beetle = new Beetle(2);
        beetle.nextPlayer();
        Integer actual = beetle.getCurrentPlayer();
        Integer expected = 1;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void nextPlayerTest2(){
        Beetle beetle = new Beetle(2);
        beetle.nextPlayer();
        beetle.nextPlayer();
        Integer actual = beetle.getCurrentPlayer();
        Integer expected = 0;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void printBeetleTest1(){
        Beetle beetle = new Beetle(2);
        String expected = "Body:0  Head:0  Legs:0  Eyes:0  Antenna:0  Tail:0  ";
        String actual = beetle.printBeetle(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastDiceRollTest(){
        Beetle beetle = new Beetle(2);
        Integer actual = beetle.getLastDiceRoll(0);
        Integer expected = 0;

        Assert.assertEquals(expected, actual);
    }
}
