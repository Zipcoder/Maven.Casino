package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;

public class KenoGame implements GameInterface {
    Integer multiplier;
    KenoPlayer kenoPlayer;
    KenoGame kenoGame;
    Integer bet;
    int balance;
    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        Scanner input = new Scanner(System.in);
        printWelcome();
        balance = 100; //Start the player off with some money
        int playerNums[] = new int[15];
        int computerNums[] = new int[20];
        int kenoSpot, kenoCatch;
        boolean continueGame = true;
        String userInput;


        System.out.println("\u001B[32mHello, and welcome to the game Keno!");
        System.out.println("\u001B[32mThis is a high stakes game. You can win and lose money quickly!");
        while(continueGame)
        {
            System.out.println();
            System.out.println("\u001B[32mYou currently have: $" + balance);
            System.out.println("\u001B[32mLet's get some numbers to begin.");
            System.out.println("\u001B[32mYou may enter up to 15 numbers");
            playerNums = getUserInput();
            bet = (int) getBet(balance);
            computerNums = getComputerNums();
            kenoSpot = getSpot(playerNums);
            kenoCatch = getCatch(playerNums, computerNums);
            System.out.println("\u001B[32mCatch: " + (kenoCatch + 1));

            System.out.println("\u001B[32mYou have won: $"+payout(kenoSpot,kenoCatch,bet));

            balance += payout(kenoSpot, kenoCatch, bet);
            subtractBetFromBalance(bet);
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
                        "******    WELCOME TO KENO   ******\n" +
                        "***                             ***\n" +
                        "***********************************");
    }

    public static int[] getUserInput()
    {
        Scanner input = new Scanner(System.in); // for input
        boolean invalidInput = true;
        boolean continuePlayer = true;
        int playerNums[] = new int[15];
        int index;
        int numberEntered;
        String enterString;
        for (index = 0; index < playerNums.length; index++ )
        {
            playerNums[index] = 0;
        }
        index = 0;
        while(continuePlayer && index < 15)
        {
            do
            {
                do
                {
                    System.out.println("\u001B[32mEnter number " + (index+1));
                    numberEntered = input.nextInt();
                    if ((numberEntered > 0) && (numberEntered < 81))
                    {
                        if(isUnique(numberEntered, playerNums))
                        {
                            invalidInput = false;
                            playerNums[index] = numberEntered;
                        }
                        else
                        {
                            System.out.println("\u001B[32mSorry, you already entered that number before!");
                            System.out.println("\u001B[32mTry again!	");
                            invalidInput = true;
                        }
                    }
                    else
                    {
                        invalidInput = true;
                        System.out.println("\u001B[32mSorry, the number you entered is either less than 0 or greater than 79");
                        System.out.println("\u001B[32mTry again");
                        System.out.println("");
                    }
                } while(invalidInput);

                if(index < 14) //makes sure program doesn't ask to continue when on the last number
                {
                    System.out.println("\u001B[32mDo you wish to continue? (y/n)");
                    input.nextLine();
                    enterString = input.nextLine();
                    if ((enterString.equals("n")) || (enterString.equals("no")))
                    {
                        invalidInput = false;
                        continuePlayer = false;
                    }
                    else if ((enterString.equals("y")) || (enterString.equals("yes")))
                    {
                        invalidInput = false;
                        continuePlayer = true;
                    }
                    else
                    {
                        System.out.println("\u001B[32mSorry, I didn't understand that.");
                        System.out.println("");
                        invalidInput = true;
                    }

                }
            }while(invalidInput);

            index++;
        }
        return playerNums;
    }

    public static boolean isUnique(int number, int[] array)
    {
        int index;
        for (index = 0; index < array.length; index++)
        {
            if(number == array[index])
            {
                return false;
            }
        }
        return true;
    }

    public static int[] getComputerNums()
    {
        int[] computerNums = new int[20];
        Random rand = new Random();
        int index;
        int randomNumber = 0;

        for (index = 0; index < computerNums.length; index++)
        {
            randomNumber = rand.nextInt(80) + 1;
            if(isUnique(randomNumber, computerNums))
            {
                computerNums[index] = randomNumber;
            }
            else
            {
                index--;
            }

        }
        return computerNums;
    }

    public static int getSpot(int[] playerArray)
    {
        int index;
        int spot = 0;
        for (index = 0; index < playerArray.length; index++)
        {
            if(playerArray[index] != 0)
            {
                spot++;
            }

        }
        spot -= 1; //Subtract one so it works properly in array
        return spot;
    }

    public static double getBet(double playerMoney)
    {
        Scanner input = new Scanner(System.in);
        double bet = 0;
        boolean invalidInput = true;
        while(invalidInput)
        {
            System.out.print("\u001B[32mEnter the bet amount in whole dollars: $");
            bet = input.nextInt();
            if(bet < 0)
            {
                System.out.println("\u001B[32mBet amount can't be less than 0!");
                invalidInput = true;
            }
            else if(bet > playerMoney)
            {
                System.out.println("\u001B[32mYou don't have enough money to bet that!");
                invalidInput = true;
            }
            else
            {
                invalidInput = false;
            }
        }
        return bet;
    }

    public static int getCatch(int[] playerArray, int[] computerArray)
    {
        int playerIndex;
        int computerIndex;
        int kenoCatch = 0;
        for (playerIndex = 0; playerIndex < playerArray.length; playerIndex++)
        {
            for(computerIndex = 0; computerIndex < computerArray.length; computerIndex++)
            {
                if(playerArray[playerIndex] == computerArray[computerIndex])
                {
                    kenoCatch++;
                }
            }
        }
        kenoCatch -= 1;//subtact one so it works in array
        return kenoCatch;
    }

    public double payout(int kenoSpot, int kenoCatch, int betAmount)
    {
        Integer payoutAmount = 0;
        Integer payout[][] =
                {
                        {3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //1
                        {1, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},  //2
                        {1, 2, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},  //3
                        {0, 2, 6, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, //4
                        {0, 1, 3, 15, 50, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},//5
                        {1, 1, 2, 3, 30, 75, 0, 0, 0, 0, 0, 0, 0, 0, 0},//6
                        {2, 0, 1, 6, 12, 36, 100, 0, 0, 0, 0, 0, 0, 0, 0},//7
                        {0, 1, 1, 3, 6, 19, 90, 720, 0, 0, 0, 0, 0, 0, 0},//8
                        {0, 1, 1, 2, 4, 8, 20, 80, 1200, 0, 0, 0, 0, 0, 0},//9
                        {0, 1, 1, 2, 3, 5, 10, 30, 600, 1800, 0, 0, 0, 0, 0},//10
                        {0, 0, 1, 1, 2, 6, 15, 25, 180, 1000, 3000, 0, 0, 0, 0},//11
                        {0, 0, 0, 1, 2, 4, 24, 72, 250, 500, 2000, 4000, 0, 0, 0},//12
                        {0, 0, 0, 1, 3, 4, 5, 20, 80, 240, 500, 3000, 6000, 0, 0},//13
                        {0, 0, 0, 0, 2, 3, 5, 12, 50, 150, 500, 1000, 2000, 7500, 0},//14
                        {0, 0, 0, 0, 1, 2, 5, 15, 50, 150, 300, 600, 1200, 2500, 10000}//15
                };
        if(kenoCatch < 0)
        {
            this.multiplier = 0;
        }
        else
        {
            multiplier = payout[kenoSpot][kenoCatch];
            payoutAmount = multiplier * betAmount;
        }
        return payoutAmount;
    }

    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        return this.multiplier*betAmount;
    }

    @Override
    public void subtractBetFromBalance(Integer betAmount) {
        this.balance-=bet;
    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

        this.balance+=calculateWinnings(multiplier,bet);
    }
}
