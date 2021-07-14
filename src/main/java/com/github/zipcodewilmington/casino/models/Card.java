package com.github.zipcodewilmington.casino.models;

import java.util.*;

public class Card {
    List<Integer> cardPool;

    // Let's hope this works! If you can see this, that'd be cool
    // Boilage <== hack

    public Card() {
        this.cardPool = new ArrayList<>();
        this.createDeck();
        this.polishDeck();
        this.shuffleDeck();
    }

    // Alter the loop to provide the correct amount of 10's
    // Jack/Queen/King
    // Should have 16 - 10 values in a 52 deck

    public void createDeck() {
        for (int i = 0; i < 4; i++) {
            for (int j = 2; j < 15; j++) {
                this.cardPool.add(j);
            }
        }
    }

    public void polishDeck() {
        for (int i = 0; i < this.cardPool.size(); i++) {
            if (this.cardPool.get(i) > 11) {
                this.cardPool.set(i, 10);
            }
        }
    }

    public void shuffleDeck() {
        Collections.shuffle(this.cardPool);
    }

    public List<Integer> getCardPool() {
        return cardPool;
    }

    public void setCardPool(List<Integer> cardPool) {
        this.cardPool = cardPool;
    }
}
