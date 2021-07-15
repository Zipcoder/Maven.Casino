package com.github.zipcodewilmington.casino.models;

public class Dice {
    private Integer numDice;
    private Integer maxRoll;
    private Integer maxBinIndex;
    private Integer[] rollValues;
    private Integer[] bins;

    public Dice(Integer numberOfDice){
        this.numDice = numberOfDice;
        this.maxRoll = numberOfDice * 6;
        this.maxBinIndex = numberOfDice * 6 - numberOfDice;
        this.rollValues = new Integer[this.numDice];
        this.bins = new Integer[numberOfDice * 6 - (numberOfDice - 1)] ;
        this.initializeDiceList();
        this.initializeBins();
    }

    public Integer getNumDice(){
        return this.numDice;
    }

    public Integer[] getRollValues(){
        return this.rollValues;
    }

    public Integer[] getBins(){
        return this.bins;
    }

    public Integer getBin(Integer binNumber){
        return this.bins[binNumber - numDice];
    }

    public Integer getMaxBinIndex() { return this.maxBinIndex; }

    public Integer getMaxRoll(){ return this.maxRoll;}

    public void incrementBin(Integer binNumber){
        this.bins[binNumber - numDice]++;
    }

    public void initializeDiceList(){
        for(int i = 0; i < numDice; i++){
            this.rollValues[i] = 0;
        }
    }

    public void initializeBins(){
        for(int i = 0; i <= maxBinIndex; i++){
            this.bins[i] = 0;
        }
    }

    public Integer tossAndSum(){
        int sum = 0;
        for(int i = 0; i < numDice; i++){
            sum += (Math.random() * 6) + 1;
        }
        this.incrementBin(sum);
        return sum;
    }

}
