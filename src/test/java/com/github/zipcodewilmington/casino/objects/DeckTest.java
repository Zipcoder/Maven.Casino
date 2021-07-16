package com.github.zipcodewilmington.casino.objects;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    @Test
    public void populateDeck() {
        String playerInput;
        final IOConsole console = new IOConsole(AnsiColor.BLUE);

        Deck deck = new Deck(1);
       deck.populateDeck();
       deck.shuffleDeck();
       ArrayList<Card> hand = new ArrayList<>();
       hand.add(deck.dealCard());

        Card[] playerHand = hand.toArray(new Card[0]);

        int x = deck.cardValue(hand.get(0));
        int y = deck.cardValue(hand.get(1));

        System.out.println(x);
    }
}