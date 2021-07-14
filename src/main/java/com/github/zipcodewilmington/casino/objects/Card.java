package com.github.zipcodewilmington.casino.objects;

public class Card {
    private final CardRank rank;
    private final CardSuit suit;

    private final String[] rankNames = {"Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace",
            "Joker"};
    private final String[] suitNames = {"Clubs", "Diamonds", "Hearts", "Spades",
            "Black", "Red"};

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }
    }