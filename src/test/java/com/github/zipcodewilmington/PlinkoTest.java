package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.plinko.PlinkoGame;
import org.junit.Assert;
import org.junit.Test;

public class PlinkoTest {

    @Test
    public void testCalculateWinnings() {
        //given

        Integer expectedValue=0;
        PlinkoGame plinkoGame=new PlinkoGame(7);
        plinkoGame.run();
        //when
        Integer actualValue=plinkoGame.calculateWinnings(2,200);

        //then
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testConstructor(){
        //given
        int expectedValue=8;
        //when
        PlinkoGame plinkoGame=new PlinkoGame(8);
        int actualValue=plinkoGame.initialPosition;
        //then
        Assert.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void testPlayPlinko(){
        //given
        String expectedValue="Invalid Entry";
        //when
        PlinkoGame plinkoGame=new PlinkoGame(10);
        String actualValue=plinkoGame.playPlinko(10);
        //then
        Assert.assertFalse(expectedValue, Boolean.parseBoolean(actualValue));
    }
}

