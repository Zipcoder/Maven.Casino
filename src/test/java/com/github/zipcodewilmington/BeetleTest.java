package com.github.zipcodewilmington;

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
        for(int i = 0; i < 6; i++) {
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
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 6; j++){
                beetle.setPlayerBeetles(0, j);
            }
            actual = beetle.checkWinner(0);
        }
        Assert.assertTrue(actual);
    }

    @Test
    public void checkWinnerTest2(){
        Beetle beetle = new Beetle(2);
        Boolean actual = false;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 6; j++){
                beetle.setPlayerBeetles(0, j);
            }
            actual = beetle.checkWinner(0);
        }
        Assert.assertFalse(actual);
    }

    @Test
    public void getScoreTest1(){
        Beetle beetle = new Beetle(2);
        for(int j = 0; j < 6; j++){
            beetle.setPlayerBeetles(0, j);
        }
        beetle.checkWinner(0);
        Integer expected = 6;
        Integer actual = beetle.getScore(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getScoreTest2(){
        Beetle beetle = new Beetle(2);

        Integer expected = 0;
        Integer actual = beetle.getScore(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void refreshBeetleTest(){
        Beetle beetle = new Beetle(2);
        for(int j = 0; j < 6; j++){
            beetle.setPlayerBeetles(0, j);
        }
        beetle.refreshBeetle(0);
        Integer[] actual = beetle.getPlayerCard(0);
        Integer[] expected = new Integer[] {0, 0, 0, 0, 0, 0};

        Assert.assertArrayEquals(actual, expected);
    }
}
