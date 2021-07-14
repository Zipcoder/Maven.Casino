package com.github.zipcodewilmington.casino.games.plinko;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlinkoGame implements GameInterface,PlayerInterface {
    private Map<Integer,Double> moneyGenerator=new HashMap<Integer, Double>();
    public int initialPosition;
    private double betAmount;
    public int randomNumber;

    public PlinkoGame(int initialPosition){
        this.initialPosition=initialPosition;
    }

    public String playPlinko(int initialPosition){
        if(initialPosition<10 && initialPosition>0){
            int max=9;
            int min=1;
            Random rand = new Random();
            int randomNumber=rand.nextInt(max - min + 1) + min;
            return String.valueOf(randomNumber);
        }
        else
            return "Invalid Entry";
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        if (initialPosition < 10 && initialPosition > 0) {
            int max = 9;
            int min = 1;
            Random rand = new Random();
            randomNumber = rand.nextInt(max - min + 1) + min;
            System.out.println("Now your position is: " + randomNumber);
        }
        else
        {
            System.out.println("Invalid Entry");
        }
    }

    @Override
    public Double calculateWinnings(Double multiplier, Double betAmount) {
        moneyGenerator.put(1,200.00);
        moneyGenerator.put(2,0.00);
        moneyGenerator.put(3,3000.00);
        moneyGenerator.put(4,30.50);
        moneyGenerator.put(5,0.00);
        moneyGenerator.put(6,0.00);
        moneyGenerator.put(7,1.00);
        moneyGenerator.put(8,750.50);
        moneyGenerator.put(9,0.00);
        Double moneyWon=0.0;
        for (Integer pos:moneyGenerator.keySet())
        {
            if(pos.equals(randomNumber)){
                moneyWon=moneyGenerator.get(pos);
            }
        }
        return moneyWon;
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

