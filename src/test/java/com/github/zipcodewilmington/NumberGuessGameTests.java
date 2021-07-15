package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import org.junit.Assert;
import org.junit.Test;

public class NumberGuessGameTests {

    @Test
    public void constructorTest1(){
        NumberGuessGame game = new NumberGuessGame();
        Integer actual = game.getMaxNumber();
        Integer expected = 20;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void setMaxNumberTest(){
        NumberGuessGame game = new NumberGuessGame();
        game.setMaxNumber(50);
        Integer actual = game.getMaxNumber();
        Integer expected = 50;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getGuessRange(){
        NumberGuessGame game = new NumberGuessGame();
        Integer guessedNumber = 10;
        Integer actualNumber = 5;
        Integer actual = game.getGuessRange(guessedNumber, actualNumber);
        Integer expected = 25;

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getGuessPercentage(){
        NumberGuessGame game = new NumberGuessGame();
        Integer guessedNumber = 10;
        Integer max = game.getMaxNumber();
        Integer actualNumber = 5;
        Integer range = Math.abs(guessedNumber - actualNumber);
        Integer actual = game.guessRangePercentage(range);
        Integer expected = 25;

        Assert.assertEquals(actual, expected);
    }
}
