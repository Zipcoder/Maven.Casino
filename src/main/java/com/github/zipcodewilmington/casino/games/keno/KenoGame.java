package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */

public class KenoGame implements GameInterface {


    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

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
    public void run() {
        guessNumbers();
        int x = getCatch(userInput(),getComputerNum());
        if( x > 0)
        {
            System.out.println("********************************");
            System.out.println("Congratulation,You have " + x + " Number Matching");
            System.out.println("********************************");
        }else{
            System.out.println("********************************");
            System.out.println("Sorry, Better luck next time");
            System.out.println("********************************");
        }


    }
        //create the array of answers to guess from
        //will create numbers from 1 to 80
        public ArrayList<Integer> guessNumbers() {
            System.out.println("Welcome to Keno Game");
            System.out.println("***       *** ***      ***");
            System.out.println("***       *** ***      ***");
            ArrayList<Integer> nums = new ArrayList<>(); //list that holds numbers to guess from
            for (int i = 1; i <= 80; i++) {
                nums.add(i);
            }
            return nums;
        }

        //will be all of the numbers that the user entered this function initially sets all the numbers in the array to 0
        //
        public int[] userInput() {
            boolean player = true;
            boolean invalidNumber = true;
            int playerNumbers[] = new int[5];
            int numberEntered;
            Scanner sc = new Scanner(System.in);

            int i = 0;

                while (player && i < playerNumbers.length) {
                    System.out.println("Enter your Number");
                    //System.out.println("Enter number " + (i + 1));
                numberEntered = Integer.parseInt(sc.nextLine());
                if (numberEntered > 0 && numberEntered < 80) {
                    if (isUnique(numberEntered, playerNumbers)) {
                        invalidNumber = false;
                        playerNumbers[i] = numberEntered;
                        i++;
                        } else {
                        System.out.println("Sorry, you already entered that number before");
                        System.out.println("Try again! ");
                            invalidNumber = true;
                        }
                }
            }
            return playerNumbers;
        }

        //check whether the number is unique or not
        public boolean isUnique ( int number, int[] array){
            for (int i = 0; i < array.length; i++) {
                if (number == array[i]) {
                    return false;
                }
            }
            return true;

        }

        // generate the numbers for the computer. numbers are generated randomly
        public int[] getComputerNum () {
            int[] computerNum = new int[20];
            Random r = new Random();
            int randomNumber = 0;

            for (int i = 0; i < computerNum.length; i++) {
                randomNumber = r.nextInt(80) + 1;
                if (isUnique(randomNumber, computerNum)) {
                    computerNum[i] = randomNumber;
                    System.out.println("Computer generated numbers are" + " " + computerNum[i]);
                } else {
                    i++;
                }

            }

            return computerNum;
        }

        //return the catch which is how many of user's number matched to the computer's
        public int getCatch(int[] playerNumbers, int[] computerNumber){

            int kenoCatch = 0;
            for (int i = 0; i < playerNumbers.length; i++) {
                for (int j = 0; j < computerNumber.length; j++) {
                    if (playerNumbers[i] == computerNumber[j]) {
                        kenoCatch++;
                    }
                }
            }
            return kenoCatch;

    }

}
