package com.github.zipcodewilmington.objects;

import com.github.zipcodewilmington.casino.objects.RouletteBet;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class RouletteBetTest {

    @Test
    public void testStreetBet(){
        //given
        int testBet = 2;
        RouletteBet bet = new RouletteBet();
        Integer[] expected = {1, 2, 3};

        //when
        Integer[] actual = bet.winningStreetArray(testBet);

        //then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testStreetBet2(){
        //given
        int testBet = 30;
        RouletteBet bet = new RouletteBet();
        Integer[] expected = {28, 29, 30};

        //when
        Integer[] actual = bet.winningStreetArray(testBet);

        //then
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void testColumn(){
        //given
        int testBet = 6;
        RouletteBet bet = new RouletteBet();
        Integer[] expected = {3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36};

        //when
        Integer[] actual = bet.winningColumn(testBet);

        //then
        Assert.assertArrayEquals(expected, actual);
    }
}
