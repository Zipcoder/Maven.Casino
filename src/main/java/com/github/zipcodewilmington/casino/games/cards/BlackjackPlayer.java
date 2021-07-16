package com.github.zipcodewilmington.casino.games.cards;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.objects.Card;

import java.util.ArrayList;

public class BlackjackPlayer implements PlayerInterface {

    ArrayList<Card> hand;

    public BlackjackPlayer(ArrayList<Card> hand, String name, String password, float balance, float currentBet) {
        super();
        this.hand = hand;
    }

    public BlackjackPlayer() {
        super();
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
