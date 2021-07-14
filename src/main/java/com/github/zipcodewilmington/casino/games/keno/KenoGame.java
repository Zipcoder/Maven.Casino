package com.github.zipcodewilmington.casino.games.keno;

import java.util.ArrayList;

/**
 * Created by leon on 7/21/2020.
 */
public class KenoGame {

    private ArrayList<Integer> numbers;  //list that holds numbers to guess from
    private ArrayList<Integer> winNumbers;  //list that holds the winning numbers

    public KenoGame(ArrayList<Integer> numbers,ArrayList<Integer> winNumbers){
        this.numbers =numbers;
        this.winNumbers = winNumbers;
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> getWinNumbers() {
        return winNumbers;
    }

    public void setWinNumbers(ArrayList<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    void getKenoGame(){

    }

    public ArrayList<Integer> setKenoGame(){
        //array of answers to guess
        numbers = new ArrayList<Integer>();
        for(int i = 1; i <= 80; i++){
            numbers.add(i);
        }
        return numbers;
    }
    //generate winning numbers to play
    public ArrayList<Integer> generateNumbers(){
        winNumbers = new ArrayList<Integer>();
        while (winNumbers.size() < 20){
            int winNum = (int)(Math.random() * 80 + 1);
            if (winNumbers.indexOf(winNum) == -1){
                winNumbers.add(winNum);
            }
        }
        return winNumbers;
    }


    
}