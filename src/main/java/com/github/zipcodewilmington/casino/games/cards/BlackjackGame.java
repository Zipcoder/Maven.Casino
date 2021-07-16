
package com.github.zipcodewilmington.casino.games.cards;
import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.objects.Card;
import com.github.zipcodewilmington.casino.objects.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

// Blackjack is a game that a player plays against a dealer
// The first card is placed face down for the player and dealer
// the second card is placed face up
// the player has the option to (HIT, HOLD, or RAISE)
// if the player goes past 21 then it is a BUST and they lose
// if the player HOLDs and their total is higher than the dealer, then they win
// if the player gets exactly 21 they win 2x the total bet

public class BlackjackGame implements GambleableGame {

    String playerInput;
    ArrayList<Card> hand;
    Deck deck;
    private final List<BlackjackPlayer> blackjackPlayers= new ArrayList<>();
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    PlayerInterface playerBlackJack;
    


    public BlackjackGame(Deck deck, ArrayList<Card> hand) {
        this.deck = deck;
        this.hand = hand;
    }

    public BlackjackGame() {
        this.deck = new Deck(1);
        this.hand = new ArrayList<Card>();

    }


    @Override
    public void run() {
        final int MAX = 21;


        BlackjackGame blackjackGame = new BlackjackGame(deck, hand);
        System.out.println("Welcome to the Sirius Blackjack table.");
        blackjackGame.getNumberOfPlayers();
        System.out.println("Have a seat and get ready for an adventure!");
        Double bet = console.getDoubleInput("How much would you like to bet?");
        System.out.println("Your bet is " + bet + "\nThe dealer will now shuffle and deal out your cards.");

        deck.populateDeck();
        deck.shuffleDeck();
        hand.add(deck.dealCard());
        hand.add(deck.dealCard());

        Card[] playerHand = hand.toArray(new Card[0]);

        System.out.println(Arrays.toString(playerHand));

        playerInput = console.getStringInput("What would you like to do? \n [HIT] [STAY]");

        if(playerInput == "hit".toLowerCase(Locale.ROOT)){
            hand.add(deck.dealCard());

            int handValue = (deck.cardValue(hand.get(0)) + deck.cardValue(hand.get(1)));

        // need to convert hand size to value of cards within hand
            if(handValue > MAX ){
                console.getStringInput("Bust! You lose. Would you like to play again? \n [ YES ] [ NO ]");

            }

        } else if(playerInput == "stay".toLowerCase(Locale.ROOT)) {
            System.out.println("Dealer's turn.");
        }



    }


    @Override
    public void add(PlayerInterface player) {
    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public int getNumberOfPlayers() {
        return blackjackPlayers.size();
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

}

