package com.github.zipcodewilmington.casino;

public interface GamblingPlayer extends PlayerInterface{

    void increaseBet(float raise);

    void decreaseBet(float deposit);

    float amountWagered();

    float amountWon();

    float payOut();
}
