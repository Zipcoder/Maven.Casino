package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.blackjack.BlackJack;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class BlackJackTest {
    @Test
    public void generateNewDeckTest() {
        BlackJack bj = new BlackJack();
        Integer expected = 52;

        Integer actual1 = bj.generateNewDeck().size();
        List<Integer> actual = bj.generateNewDeck();
        System.out.println(actual);

        Assert.assertEquals(expected, actual1);
    }

    @Test
    public void givePlayerCardTest() {
        BlackJack bj = new BlackJack();
        Integer expected = 2;

        bj.givePlayerCard();
        bj.givePlayerCard();
        Integer actual = bj.getPlayersHand().size();

        System.out.println(bj.getPlayersHand());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void giveDealerCardTest () {
        BlackJack bj = new BlackJack();
        Integer expected = 2;

        bj.giveDealerCard();
        bj.giveDealerCard();
        Integer actual = bj.getDealersHand().size();

        System.out.println(bj.getDealersHand());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playersCurrentValueTest () {
        BlackJack bj = new BlackJack();

        // Solid stopping point = need to populate array for test
        bj.givePlayerCard();
        bj.givePlayerCard();
        System.out.println(bj.playersCurrentValue());

        List<Integer> expected = bj.getPlayersHand();

        bj.playersCurrentValue();
        Integer actual = bj.playersCurrentValue();

        System.out.println(expected);
        System.out.println(actual);
    }

    @Test
    public void dealersCurrentValueTest () {
        BlackJack bj = new BlackJack();
        List<Integer> expected = bj.getDealersHand();

        bj.dealersCurrentValue();
        Integer actual = bj.dealersCurrentValue();

        System.out.println(expected);
        System.out.println(actual);
    }

    @Test
    public void givePlayerCardOnSplitTest () {
        BlackJack bj = new BlackJack();
        List<Integer> expected = bj.getPlayersHandOnSplit();

        List<Integer> actual = bj.givePlayerCardOnSplit();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void splitPlayersCurrentValueTest () {
        BlackJack bj = new BlackJack();
        Integer expected = 0;

        bj.getPlayersHandOnSplit().add(0);
        Integer actual = bj.splitPlayersCurrentValue();

        Assert.assertEquals(expected, actual);
    }
}
