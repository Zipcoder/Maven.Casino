package com.github.zipcodewilmington.casino.objects;

public class Card implements Comparable<Card>{
    private final CardRank rank;
    private final CardSuit suit;

    private final String[] rankNames = {"Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    private final String[] suitNames = {"Clubs", "Diamonds", "Hearts", "Spades",
            "Black", "Red"};

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    public CardRank getCardValue() {
        return this.rank;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        final Card other = (Card) obj;

        return this.rank == other.getRank() && this.suit == other.getSuit();
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    @Override
    public int compareTo(Card other) {
        if (other == null)
            throw new NullPointerException();

        return (this.suit.ordinal() * CardRank.values().length +
                this.rank.ordinal()) - (other.getSuit().ordinal() *
                CardRank.values().length + other.getRank().ordinal());


    }

    @Override
    public String toString() {
        return rankNames[rank.ordinal()] + " of " + suitNames[suit.ordinal()];
    }
}
