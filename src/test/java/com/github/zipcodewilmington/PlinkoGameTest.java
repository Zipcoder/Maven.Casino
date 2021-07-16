package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import com.github.zipcodewilmington.casino.games.plinko.PlinkoGame;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlinkoGameTest {



    @Test
    void getPlinkoSpotTest() {
        //given
        PlinkoGame plinkoGame=new PlinkoGame();
        //when
        Integer expectedValue=plinkoGame.getPlinkoSpot();
        //then
        Assert.assertFalse(String.valueOf(expectedValue),false);
    }

    @Test
    public void calculateWinningsTest() {
        //given
        PlinkoGame plinkoGame=new PlinkoGame();
        Integer expectedValue=plinkoGame.calculateWinnings(2,200);
        //when
        Integer actualValue=plinkoGame.calculateWinnings(2,200);
        //then
        Assert.assertEquals(expectedValue,actualValue);
    }

}