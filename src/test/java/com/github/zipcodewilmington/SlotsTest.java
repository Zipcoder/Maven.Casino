package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.slots.Slots;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class SlotsTest {

    @Test
    public void slotConstructorTest(){
        //given
        String[][] expected =  {
            {"Peach", "Cherry", "Diamond"},
            {"Diamond", "Plum", "Nine"},
            {"Seven", "Peach", "Diamond"}};
        //when
        Slots slot = new Slots();
        String[][] retrieved =  slot.getSlots();
        //then
        Assert.assertEquals(expected, retrieved);
    }

    @Test
    public void setSlotTest(){
        //given
        Slots slot = new Slots();
        String[][] given =  {
                {"Cherry", "Cherry", "Cherry"},
                {"Diamond", "Plum", "Nine"},
                {"Seven", "Peach", "Diamond"}};
        //when
        slot.setSlots(given);
        String[][] retrieved = slot.getSlots();
        //then
        Assert.assertEquals(given,retrieved);
    }

    @Test
    public void getSlotTest(){
        //given
        String[][] expected =  {
                {"Peach", "Cherry", "Diamond"},
                {"Diamond", "Plum", "Nine"},
                {"Seven", "Peach", "Diamond"}};
        //when
        Slots slot = new Slots();
        String[][] retrieved =  slot.getSlots();
        //then
        Assert.assertEquals(expected, retrieved);
    }

    @Test
    public void randomItemTest(){
        //given
        String[] given = {"Peach", "Cherry", "Diamond"};
        String[] retrieved = {"Peach", "Cherry", "Diamond"};
        //when
        for (int i = 0; i < retrieved.length; i++) {
            retrieved[i] = Slots.ramdomSlotItem();
        }
        //then
        Assert.assertFalse(given.equals(retrieved));
    }

    @Test
    public void spinSlotsTest(){
        //given
        Slots slotMachine = new Slots();
        String[][] given =  slotMachine.getSlots();
        //when
        slotMachine.spinSlots();
        String[][] retrieved =  slotMachine.getSlots();
        //then
        Assert.assertFalse(given.equals(retrieved));
    }

    @Test
    public void initializeWinningLinesTest(){
        //given
        Slots slot = new Slots();
        String[] expected = {"LOSE","LOSE","LOSE","LOSE","LOSE","LOSE","LOSE","LOSE",};
        HashMap initialWinningLines = slot.getWinningLines();
        String[] returned = new String[8];
        for (int i = 0; i < initialWinningLines.size(); i++) {
            returned[i] = (String) initialWinningLines.get(i + 1);
        }
        //then
        Assert.assertEquals(expected, returned);

    }

    @Test
    public void setWinningLinesTest(){
        //given
        String[][] given =  {
                {"Peach", "Peach", "Peach"},
                {"Peach", "Peach", "Peach"},
                {"Peach", "Peach", "Peach"}};
        Slots slot = new Slots(given);
        String[] expected = {"WIN","WIN","WIN","WIN","WIN","WIN","WIN","WIN"};
        //when
        slot.setWinningLines();
        HashMap winningLines = slot.getWinningLines();
        String[] returned = new String[8];
        for (int i = 0; i < winningLines.size(); i++) {
            returned[i] = (String) winningLines.get(i + 1);
        }
        //then
        Assert.assertEquals(expected,returned);

    }

    @Test
    public void compareBetVsWinningLinesTest(){
        //given
        String[][] given =  {
                {"Peach", "Peach", "Peach"},
                {"Peach", "Peach", "Peach"},
                {"Peach", "Peach", "Peach"}};
        Slots slot = new Slots(given);
        slot.setWinningLines();
        String[] expected = {"WIN","WIN","WIN","WIN","WIN","WIN","WIN","WIN"};
        Integer [] bets = {1,2,3,4,5,6,7,8};
        //when
        String[] returned = slot.compareBetVsWinningLines(bets);
        //then
        Assert.assertEquals(expected, returned);
    }

    @Test
    public void displaySlotsTest(){
        //given
        Slots slot = new Slots();
        //when
        slot.displaySlots();
        //then - check output
    }

}
