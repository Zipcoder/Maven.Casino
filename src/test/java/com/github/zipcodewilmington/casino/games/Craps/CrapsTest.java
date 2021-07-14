package com.github.zipcodewilmington.casino.games.Craps;

import com.github.zipcodewilmington.casino.games.CrapsGame.CrapsGame;
import com.github.zipcodewilmington.casino.games.CrapsGame.Dice;
import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    @Test
    public void firstRollTest(){
        //given
        CrapsGame game = new CrapsGame();
        int expected=0;
        //when
        int actual= game.firstRoll();

        //then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void secondRollTest(){
        //given
        CrapsGame game = new CrapsGame();
        int expected=0;
        //when
        int actual= game.secondRoll();

        //then
        Assert.assertNotEquals(expected, actual);
    }
    @Test
    public void sumOfRollTest(){
        //given
        CrapsGame game = new CrapsGame();
        int num1=7;
        int num2=11;
        boolean expected = true;
        //when
        boolean actual =game.sumOfRoll(num1, num2);

        //then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void sumOfRollTest2(){
        //given
        CrapsGame game = new CrapsGame();
        int num1=7;
        int num2=6;
        boolean expected = false;
        //when
        boolean actual =game.sumOfRoll(num1, num2);

        //then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void sumOfRollTest3(){
        //given
        CrapsGame game = new CrapsGame();
        int num1=6;
        int num2=7;
        boolean expected = false;
        //when
        boolean actual =game.sumOfRoll(num1, num2);

        //then
        Assert.assertEquals(expected, actual);
    }

}

