package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.models.Dice;
import org.junit.Assert;
import org.junit.Test;

public class DiceTest {
    @Test
    public void diceConstructorTest1() {
        Dice dice = new Dice(2);
        Integer actual = dice.getNumDice();
        Integer expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void diceConstructorTest2() {
        Dice dice = new Dice(3);
        Integer expected = 18;
        Integer actual = dice.getMaxRoll();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void diceConstructorTest3() {
        Dice dice = new Dice(3);
        Integer expected = 14;
        Integer actual = dice.getMaxBinIndex();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void diceConstructorTest4() {
        Dice dice = new Dice(3);
        Integer expected = 3;
        Integer actual = dice.getRollValues().length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void diceConstructorTest5() {
        Dice dice = new Dice(2);
        Integer expected = 10;
        Integer actual = dice.getBins().length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void diceConstructorTest6() {
        Dice dice = new Dice(2);
        Integer[] expected = {0, 0};
        Integer[] actual = dice.getRollValues();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void diceConstructorTest7(){
        Dice dice = new Dice(2);
        Integer[] expected = {0,0,0,0,0,0,0,0,0};
        Integer[] actual = dice.getBins();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getBinQuantityTest(){
        Dice dice = new Dice(2);
        dice.tossAndSum();
        Integer[] bins = dice.getBins();
        Integer actual = 0;
        for(int i = 2; i < dice.getMaxBinIndex(); i++){
            if(dice.getBin(i) > 0){
                actual = dice.getBin(i);
                break;
            }
        }
        Integer expected = 1;

        Assert.assertEquals(expected, actual);
    }

}
