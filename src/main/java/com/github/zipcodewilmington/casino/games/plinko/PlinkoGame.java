package com.github.zipcodewilmington.casino.games.plinko;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class PlinkoGame implements GameInterface{
    private Map<Integer,Integer> moneyGenerator=new HashMap<Integer, Integer>();
    private PlayerInterface playerInt;
    public int initialPosition;
    private int bet;
    public int multiplier;
    public int balance;



    @Override
    public void add(PlayerInterface player) {
        this.playerInt=player;
    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        printWelcome();
        balance=playerInt.getArcadeAccount().getAccountBalance();
        boolean continueGame=true;
        Integer playerNumber;
        String userInput;

        System.out.println("\u001B[32mHello, and welcome to the game Plinko!");
        while(continueGame){
            System.out.println("\u001B[32mYou currently have: $" + playerInt.getArcadeAccount().getAccountBalance());
            System.out.println("\u001B[32mPlease enter a number position of your choice: ");
            playerNumber = getUserInput();
            bet = (int) getBet(balance);
            int plinkSpot=getPlinkoSpot();
            this.multiplier=plinkSpot;
            System.out.println("\u001B[32mAfter playing, now your position is: "+plinkSpot);
            balance += payout(plinkSpot);
            subtractBetFromBalance(bet);
            playerInt.getArcadeAccount().alterAccountBalance(balance);
            System.out.println("\u001B[32mYou now have: $" + balance);
            if (balance <= 0)
            {
                continueGame = false;
                System.out.println("\u001B[32mSorry, you ran out of money!");
                System.out.println("\u001B[32mBetter luck next time! :)");
            }
            else
            {
                System.out.println("\u001B[32mWould you like to continue(y/n)?");
                userInput = input.nextLine();

                if ((userInput.equals("y")))
                {
                    continueGame = true;
                }
                else
                {
                    continueGame = false;
                }
            }
        }
        System.out.println("\u001B[32mThanks for playing!");
        System.out.println("\u001B[32mOverall, you now have: $" + balance);
    }


    private void printWelcome() {
        System.out.println(
                "\u001B[33m***********************************\n" +
                        "***                             ***\n" +
                        "******    WELCOME TO PLINKO   ******\n" +
                        "***                             ***\n" +
                        "***********************************");
    }

    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return this.multiplier*betAmount;
    }

    private int payout(int plinkoSpot) {
        moneyGenerator.put(1,200);
        moneyGenerator.put(2,0);
        moneyGenerator.put(3,3000);
        moneyGenerator.put(4,30);
        moneyGenerator.put(5,0);
        moneyGenerator.put(6,0);
        moneyGenerator.put(7,1);
        moneyGenerator.put(8,750);
        moneyGenerator.put(9,0);
        Integer moneyWon=0;

        for (Integer pos:moneyGenerator.keySet())
        {
            if(pos.equals(plinkoSpot)){
                moneyWon=moneyGenerator.get(pos);
            }
        }
        return moneyWon;
    }



    public int getPlinkoSpot() {
        int max = 9;
        int min = 1;
        Random rand = new Random();
        return rand.nextInt(max - min + 1) + min;
    }

    public static double getBet(double playerMoney)
    {
        Scanner input = new Scanner(System.in);
        double bet = 0;
        boolean invalidInput = true;
        while(invalidInput)
        {
            System.out.print("Enter the bet amount in whole dollars: $");
            bet = input.nextInt();
            if(bet < 0)
            {
                System.out.println("Bet amount can't be less than 0!");
                invalidInput = true;
            }
            else if(bet > playerMoney)
            {
                System.out.println("You don't have enough money to bet that!");
                invalidInput = true;
            }
            else
            {
                invalidInput = false;
            }
        }
        return bet;
    }

    private Integer getUserInput() {
        Scanner input = new Scanner(System.in); // for input
        boolean invalidInput = true;
        boolean continuePlayer = true;
        int numberEntered;
        int playerNums=0;
        String enterString;



        while(invalidInput)
        {
            System.out.println("Enter number :");
            numberEntered = input.nextInt();

            if ((numberEntered > 0) && (numberEntered < 10)){
                invalidInput = false;
                playerNums = numberEntered;
                break;
            }
            else{
                invalidInput = true;
                System.out.println("Sorry, the number you entered is either less than 0 or greater than 9");
                System.out.println("Try again");
                System.out.println("");
            }
        }
        return playerNums;
    }



    @Override
    public void subtractBetFromBalance(Integer betAmount) {
        balance-=bet;
    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

    }

//    @Override
//    public CasinoAccount getArcadeAccount() {
//        return null;
//    }

}


