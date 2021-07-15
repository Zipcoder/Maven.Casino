package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.IOConsole;


public class BlackJackGame implements GameInterface {
    private Boolean isRunning = false;
    private PlayerInterface playerInt;
    Integer userBet;
    Integer splitBet;
    IOConsole input = new IOConsole();
    Integer winnings = 0;
    BlackJack bj;


    /*
        reorder the 'helper' methods for more clarity
    * need formatting on splitHand
    * need refinement on formatting the beginning
    * make it flashy
    */

    public BlackJackGame () {

    }

    public void run() {
        System.out.println("\u001B[36m============================================================");
        System.out.println("\u001B[36m=====                                                  =====");
        System.out.println("\u001B[36m=====                     WELCOME                      =====");
        System.out.println("\u001B[36m=====                       TO                         =====");
        System.out.println("\u001B[36m=====                    B L A C K                     =====");
        System.out.println("\u001B[36m=====                     J A C K                      =====");
        System.out.println("\u001B[36m=====                                                  =====");
        System.out.println("\u001B[36m============================================================");
        while(!isRunning) {
            // include betting range
            playerInt.getArcadeAccount().alterAccountBalance(winnings);
            System.out.println("Your current balance is... " +  playerInt.getArcadeAccount().getAccountBalance() + "\n");
            Integer userInput = input.getIntegerInput("\u001B[32m1. Start A Hand" + "\n" + "\u001B[31m2. Quit" + "\n");
            switch (userInput) {
                case 1:
                    BlackJack freshHand = new BlackJack();
                    bj = freshHand;
                    userBet = (input.getIntegerInput("\u001B[32mHow much would you like to bet?" + "\n"));
                    userBetCondition();
                    playerInt.getArcadeAccount().alterAccountBalance(userBet * (-1));
                    startGame();
                    break;
                case 2:
                    isRunning = true;
            }
        }
    }

    public void startGame () {
            bj.givePlayerCard();
            System.out.println("Your starting card : " + bj.playersCurrentValue());
            System.out.println("Your second next card : " + bj.givePlayerCard());
            System.out.println("Hand value : " + bj.playersCurrentValue());
            if (twoCardBlackJack()) {
                calculateWinnings(3, userBet);
            } else if (bj.playersHand.get(0).equals(bj.playersHand.get(1))) {  // include conditional on starting blackjack!
                splitPlayer();
            } else {
                standardGame();
        }
    }

    public boolean twoCardBlackJack () {
        if ((bj.playersHand.get(0) + bj.playersHand.get(1)) == 21) {
            calculateWinnings(3, userBet);
            return true;
        }
        return false;
    }

    public void standardGame () {
        boolean isWinner = false;
        while (!isWinner) {
            System.out.println("With the value of  " + bj.playersCurrentValue() + "\n");
            Integer userChoice = input.getIntegerInput("1. Hit" + "\n" + "2. Stay");
            switch (userChoice) {
                case 1:
                    bj.givePlayerCard();
                    if (checkStandardWinner()) {
                        isWinner = true;
                    }
                    break;
                case 2:
                    bj.giveDealerCard();
                    System.out.println("The dealers first card : " + bj.dealersCurrentValue());
                    bj.giveDealerCard();
                    dealersGame();
                    isWinner = true;
                    break;
            }
        }
    }

    public void splitPlayer () {
        Integer choice = input.getIntegerInput("1. Split" + "\n" + "2. No, I'll play this hand");
        if (choice.equals(2)) {
            standardGame();
        } else {    // include another betting portion for this hand
            splitHandRound();
        }
    }


    public CasinoAccount getArcadeAccount() {
        return null;
    }


    public Integer calculateWinnings(Integer multiplier, Integer userBet) {
            winnings = multiplier * userBet;
            return winnings;
    }


    private void splitPlayerHitsBlackJack(Integer splitBet) {
        System.out.println("BLACK JACK!!");
        calculateWinnings(3, splitBet);
        standardGame();
    }

    private void splitPlayerBust(Integer splitBet) {
        System.out.println("Sorry bud, you got " + bj.splitPlayersCurrentValue() +
                ", you still have one more hand!");
        calculateWinnings(0, splitBet);
        standardGame();
    }

    private boolean checkStandardWinner() {
        boolean playerWon;
        System.out.println("Current hand value " + bj.playersCurrentValue() + "\n");
        if(bj.playersCurrentValue() > 21) {
            playerBustButHasAces();
            if (bj.playersCurrentValue() > 21) {
                System.out.println("Sorry bud, you got " + bj.playersCurrentValue() +
                        ", better luck next time" + "\n");
                calculateWinnings(0, userBet);
                playerWon = true;
            } else {
                playerWon = false;
            }
        } else if (playerHitsBlackJack()) {
            System.out.println("BLACK JACK!!" + "\n");
            calculateWinnings(3, userBet);
            playerWon = true;
        } else {
            playerWon = false;
        }
        return playerWon;
    }


    private Integer secondHandBet() {
        Integer splitValue = bj.playersHand.get(1);
        bj.playersHandOnSplit.add(splitValue);
        bj.playersHand.set(1, 0);
        Integer splitBet = input.getIntegerInput("Please place your bet for the second hand" + "\n");
        splitHandBetConditions();
        playerInt.getArcadeAccount().alterAccountBalance(splitBet * (-1));
        System.out.println("Your hand has been split! Current value " + bj.splitPlayersCurrentValue() + "\n" + "\n");
        return splitBet;
    }

    private void splitHandRound() {
        boolean isWinnerSecondHand = false;
        Integer splitBet = secondHandBet();
        while (!isWinnerSecondHand) {
            Integer userInput = input.getIntegerInput("1. Hit" + "\n" + "2. Stay");
            switch (userInput) {
                case 1:
                    bj.givePlayerCardOnSplit();
                    System.out.println("Current hand value " + bj.splitPlayersCurrentValue());
                    if (bj.splitPlayersCurrentValue() > 21) {
                        splitHandBustHasAces();
                        if (bj.splitPlayersCurrentValue() > 21) {
                            splitPlayerBust(splitBet);
                            isWinnerSecondHand = true;
                        } else {
                            isWinnerSecondHand = false;
                        }
                    } else if (splitPlayerHitsBlackJack()) {
                        splitPlayerHitsBlackJack(splitBet);
                        isWinnerSecondHand = true;
                    }
                    break;
                case 2:
                    standardGame();
            }
        }
    }
    public void dealersGame() {
        boolean gameEnd = false;
        while (!gameEnd) {
            System.out.println("The dealer has : " + bj.dealersCurrentValue());
            if (bj.dealersCurrentValue() > 21) {
                System.out.println("You win!");
                calculateWinnings(2, userBet);
                gameEnd = true;
            } else if (bj.dealersCurrentValue() == 21) {
                System.out.println("The dealer has won!");
                calculateWinnings(0, userBet);
                gameEnd = true;
            } else if (bj.dealersCurrentValue() > bj.playersCurrentValue()) {
                System.out.println("The dealer has won!");
                calculateWinnings(0, userBet);
                gameEnd = true;
            } else {
                bj.giveDealerCard();
            }
        }
    }

    public void playerBustButHasAces () {
        for (int i = 0; i < bj.playersHand.size(); i++) {
            if (bj.playersHand.get(i).equals(11)) {
                bj.playersHand.set(i, 1);
                System.out.println("You had an Ace - we reduced that 11 to a 1! Keep going!" + "\n" );
                break;
            }
        }
    }

    public void dealerBustButHasAces () {
        for (int i = 0; i < bj.dealersHand.size(); i++) {
            if (bj.dealersHand.get(i).equals(11)) {
                bj.dealersHand.set(i, 1);
                break;
            }
        }
    }

    public void splitHandBustHasAces () {
        for (int i = 0; i < bj.playersHandOnSplit.size(); i++) {
            if (bj.playersHandOnSplit.get(i).equals(11)) {
                bj.playersHandOnSplit.set(i, 1);
                System.out.println("You had an Ace - we reduced that 11 to a 1! Keep going!" + "\n" );
                break;
            }
        }
    }

    public boolean splitPlayerHitsBlackJack () {
        if (bj.splitPlayersCurrentValue() == 21) {
            calculateWinnings(3, splitBet);
            return true;
        } else {
            return false;
        }
    }

    public boolean playerHitsBlackJack() {
        if (bj.playersCurrentValue() == 21) {
            calculateWinnings(3, userBet);
            return true;
        } else {
            return false;
        }
    }

    public void userBetCondition () {
        while (userBet > playerInt.getArcadeAccount().getAccountBalance()) {
            System.out.println("Oh no! You're trying to place a bet with more money than you have...");
            userBet = (input.getIntegerInput("\u001B[32mHow much would you like to bet?" + "\n"));
        }
    }

    public void splitHandBetConditions () {
        while (secondHandBet() > playerInt.getArcadeAccount().getAccountBalance()) {
            System.out.println("You don't have enough money for that, Silly!");
            secondHandBet();
        }
    }

    public void subtractBetFromBalance(Integer betAmount) {

    }


    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

    }

    public void add(PlayerInterface player) {
        this.playerInt = player;
    }


    public void remove(PlayerInterface player) {

    }


}
