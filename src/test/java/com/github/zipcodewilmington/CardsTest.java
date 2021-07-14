package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.models.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CardsTest {
    @Test
    public void constructorTest () {
        Integer expected = 52;

        Card card = new Card();
        Integer actual = card.getCardPool().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createDeckTest () {
        // Given
        Integer expected = 52;

        Card card = new Card();
        Integer actual = card.getCardPool().size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void polishDeckTest () {
        Card card = new Card();

        card.polishDeck();
        System.out.println(card.getCardPool().size());
        System.out.println(card.getCardPool());
//        System.out.println(result);
    }

    @Test
    public void shuffleDeckTest () {
        Card card = new Card();

        System.out.println(card.getCardPool().size());
        System.out.println(card.getCardPool()); // Visual test
    }

    @Test
    public void setCardPoolTest () {
        Card card = new Card();
    }

    @Test
    public void setNumberOfCardsTest () {

    }
}
