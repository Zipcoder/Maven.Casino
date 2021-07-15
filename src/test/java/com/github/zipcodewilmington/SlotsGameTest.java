package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import org.junit.Assert;
import org.junit.Test;

public class SlotsGameTest {
    @Test
    public void calculateMultiplierTest(){
        //given
        SlotsGame newSlotsGame = new SlotsGame();
        String[] betResults = {"WIN", "WIN", "LOSE", "LOSE"};
        Integer expectedWin = 2;
        Integer expectedLose = 2;
        //when
        newSlotsGame.calculateMultiplier(betResults);
        Integer retrievedWin = newSlotsGame.getWinMultiplier();
        Integer retrievedLose = newSlotsGame.getLoseMultiplier();
        //then
        Assert.assertEquals(expectedWin, retrievedWin);
        Assert.assertEquals(expectedLose, retrievedLose);


    }

    @Test
    public void calculateWinningsTest(){
        //given
        SlotsGame newGame = new SlotsGame();
        Integer expected = 10;
        //when
        Integer actual = newGame.calculateWinnings(2, 5);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateReturnTotal(){
        //given
        SlotsGame newGame = new SlotsGame();
        newGame.setBetTotal(80);
        Integer expected = 100;
        //when
        Integer actual = newGame.calculateReturnTotal(50, 30);
        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getBetSelectionTest(){
        //given
        SlotsGame newGame = new SlotsGame();
        newGame.getBetSelections();

    }
}
