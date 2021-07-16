package com.github.zipcodewilmington.casino.games.cards;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.objects.Deck;


// Texas-Hold-Em begins with a beginning $ ante. Each player then receives 2 cards from the dealer.
// Beginning with the player to the left of the dealer.
// The player may: (FOLD, CALL, RAISE, CHECK)
// The game continues to each player until all players have fully placed bets
// The dealer then reveals the Flop - (first 3 community cards revealed)
// Play loops through players again
// Dealer reveals the Turn - (fourth community card revealed)
// Play loops through

public class TexasHoldEmGame implements GambleableGame, GamblingPlayer {



    Deck deck;

    public TexasHoldEmGame(Deck deck) {
        this.deck = deck;
    }

    public TexasHoldEmGame() {

    }


    @Override
    public void increaseBet(float raise) {

    }

    @Override
    public void decreaseBet(float deposit) {

    }

    @Override
    public float amountWagered() {
        return 0;
    }

    @Override
    public float amountWon() {
        return 0;
    }

    @Override
    public float payOut() {
        return 0;
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public boolean playerWins() {
        return false;
    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    @Override
    public void clearGame() {

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
