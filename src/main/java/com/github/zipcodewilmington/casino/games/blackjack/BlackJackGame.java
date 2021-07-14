package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Scanner;

public class BlackJackGame implements GameInterface, PlayerInterface {
    private BlackJack game;
    private Boolean isRunning = false;
    private PlayerInterface player;
    private Double userBet;
    IOConsole input = new IOConsole();

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        while(isRunning) {
            // include betting range

            BlackJack bj = new BlackJack();
            Integer userInput = input.getIntegerInput("1. Start A Hand" + "\n" + "2. Quit" + "\n");

            switch (userInput) {
                case 1: // include betting forum in case 1
                    startGame();
                    break;
                case 2:
                    isRunning = true;
            }
        }
    }

    public void startGame () {
        BlackJack bj = new BlackJack();
        bj.givePlayerCard();
        System.out.println("Your starting card : " + bj.playersCurrentValue());
        bj.givePlayerCard();
        System.out.println("Your second next card : " + bj.playersCurrentValue());
        boolean isWinner = false;
        Integer userChoice = input.getIntegerInput("1. Hit" + "\n" + "2. Stay");
        while (isWinner) {
                switch (userChoice) {
                    case 1:
                        bj.givePlayerCard();
                        bj.playersCurrentValue();
                        if(bj.playerBreaks21()) {
                            System.out.println("Sorry bud, you got " + bj.playersCurrentValue() +
                                    "better luck next time");
                            subtractBetFromBalance(userBet);
                            isWinner = true;
                        } else if (bj.playerHitsBlackJack()) {
                            System.out.println("BLACK JACK!!");
                            calculateWinnings(3.0, userBet);
                            isWinner = true;
                        }
                        break;
                    case 2:

                }
            }
    }

    @Override
    public Double calculateWinnings(Double multiplier, Double betAmount) {
        return multiplier * betAmount;
    }

    @Override
    public void subtractBetFromBalance(Double betAmount) {

    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Double winnings) {

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
