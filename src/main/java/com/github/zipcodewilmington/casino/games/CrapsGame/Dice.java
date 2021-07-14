package com.github.zipcodewilmington.casino.games.CrapsGame;

public class Dice {
    int dice;
    int die1;
    int die2;

    public Dice(){
        dice=0;
        die2=0;
        die1=0;
    }
    public int dieNumOne(){
            die1=(int)(Math.random()*6+1);
            return die1;
    }
    public int dieNumTwo(){
            die2=(int)(Math.random()*6+1);
            return die2;
    }
    public int rollingTheDice(){
        dice=dieNumOne()+dieNumTwo();
        return dice;
    }
}
