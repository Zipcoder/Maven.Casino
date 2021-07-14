package com.github.zipcodewilmington.casino.games.Craps;

import com.github.zipcodewilmington.casino.games.CrapsGame.Dice;
import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void diceTest(){
        //given
        Dice dice = new Dice();
        int expected=0;
        //when
        int actual = dice.rollingTheDice();

        //then
        Assert.assertNotEquals(expected, actual);

    }
}
