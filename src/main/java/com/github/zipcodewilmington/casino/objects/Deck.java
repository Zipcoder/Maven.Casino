package com.github.zipcodewilmington.casino.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Deck {

    private final int NUM_DECKS = 1;
    public LinkedList<Card> deck;


    public Deck(int NUM_DECKS) {
        deck = new LinkedList<>();
    }

    public static void main(String[] args) {
        Deck deck = new Deck(1);
        deck.populateDeck();
        System.out.println(deck);
    }

    public void populateDeck() {
        CardRank[] ranks = {CardRank.TWO, CardRank.THREE, CardRank.FOUR,
                CardRank.FIVE, CardRank.SIX, CardRank.SEVEN, CardRank.EIGHT,
                CardRank.NINE, CardRank.TEN, CardRank.JACK, CardRank.QUEEN,
                CardRank.KING, CardRank.ACE};
        CardSuit[] suits = {CardSuit.CLUBS, CardSuit.DIAMONDS, CardSuit.HEARTS,
                CardSuit.SPADES};


        for (int i = 0; i < NUM_DECKS; i++) {
            for (int j = 0; j < 52; j++)
                deck.add(new Card(ranks[j / 4], suits[j % 4]));
        }
    }


    public int cardValue(Card card) {
        int totalValue = 0;
        int aces = 0;

        for (Card c : this.deck) {
            switch (c.getCardValue()) {
                case TWO:
                    totalValue += 2;
                case THREE:
                    totalValue += 3;
                case FOUR:
                    totalValue += 4;
                case FIVE:
                    totalValue += 5;
                case SIX:
                    totalValue += 6;
                case SEVEN:
                    totalValue += 7;
                case EIGHT:
                    totalValue += 8;
                case NINE:
                    totalValue += 9;
                case TEN:
                    totalValue += 10;
                case JACK:
                    totalValue += 10;
                case QUEEN:
                    totalValue += 10;
                case KING:
                    totalValue += 10;
                case ACE:
                    aces += 11;
                    break;
            }
        }
        return totalValue;
    }


    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public Card dealCard() {
        return deck.pop();
    }


}
