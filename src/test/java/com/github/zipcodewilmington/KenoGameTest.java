package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KenoGameTest {


    @Test
    void testForIsUnique() {
        //given
        KenoGame kenoGame=new KenoGame();
        //when
        Boolean boolVal=kenoGame.isUnique(7, new int[]{7, 7});
        //then
        Assert.assertFalse(String.valueOf(boolVal),false);
    }

    @Test
    void testisUnique() {
        //given
        KenoGame kenoGame=new KenoGame();
        //when
        Boolean boolVal=kenoGame.isUnique(7, new int[]{1, 7});
        //then
        Assert.assertTrue(String.valueOf(boolVal),true);
    }


    @Test

    void testPayOut(){
        //given
        int kenoSpot=11;
        int kenoCatch=9;
        KenoGame kenoGame=new KenoGame();
        //when
        Double expectedValue=kenoGame.payout(11,9,200);
        //then
        Assert.assertTrue(String.valueOf(expectedValue),true);
    }


}