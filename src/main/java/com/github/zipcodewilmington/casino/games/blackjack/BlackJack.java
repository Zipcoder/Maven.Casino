package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.models.Card;

import java.util.*;

public class BlackJack {
    List<Integer> playersHand;
    List<Integer> playersHandOnSplit;
    List<Integer> dealersHand;
    Deque<Integer> deckOfCards;
    Integer betAmount; // Equal to user input

    public BlackJack() {
        this.playersHand = new ArrayList<>();
        this.playersHandOnSplit = new ArrayList<>();
        this.dealersHand = new ArrayList<>();
        this.deckOfCards = new ArrayDeque<>(generateNewDeck());
    }

    public List<Integer> generateNewDeck() {
        Card card = new Card();
        card.polishDeck();
        card.shuffleDeck();
        return card.getCardPool();
    }

    public List<Integer> givePlayerCard() {
        Integer valueOfCard = deckOfCards.pop();
        this.playersHand.add(valueOfCard);
        return this.playersHand;
    }

    public List<Integer> givePlayerCardOnSplit() {
        Integer valueOfCard = deckOfCards.pop();
        this.playersHandOnSplit.add(valueOfCard);
        return this.playersHandOnSplit;
    }

    public List<Integer> giveDealerCard() {
        Integer valueOfCard = deckOfCards.pop();
        this.dealersHand.add(valueOfCard);
        return this.dealersHand;
    }

    public Integer splitPlayersCurrentValue () {
        Integer sum = 0;
        for (int i = 0; i < this.playersHandOnSplit.size(); i++) {
            sum += this.playersHandOnSplit.get(i);
        }
        return sum;
    }

    public Integer playersCurrentValue() {
        Integer sum = 0;
        for (int i = 0; i < this.playersHand.size(); i++) {
            sum += this.playersHand.get(i);
        }
        return sum;
    }

    public Integer dealersCurrentValue() {
        Integer sum = 0;
        for (int i = 0; i < this.dealersHand.size(); i++) {
            sum += this.dealersHand.get(i);
        }
        return sum;
    }



    public boolean playerBreaks21() {
        if (playersCurrentValue() > 21) {
            return true;
        } else {
            return false;
        }
    }



    public List<Integer> getPlayersHand() {
        return playersHand;
    }

    public void setPlayersHand(List<Integer> playersHand) {
        this.playersHand = playersHand;
    }

    public List<Integer> getDealersHand() {
        return dealersHand;
    }

    public void setDealersHand(List<Integer> dealersHand) {
        this.dealersHand = dealersHand;
    }

    public List<Integer> getPlayersHandOnSplit() {
        return playersHandOnSplit;
    }

    public void setPlayersHandOnSplit(List<Integer> playersHandOnSplit) {
        this.playersHandOnSplit = playersHandOnSplit;
    }
}