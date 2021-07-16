package com.github.zipcodewilmington.casino.objects;

import java.util.Random;

public class Dice {

    public static int roll() {
        Random randomGenerator = new Random();
        int dice1 = randomGenerator.nextInt(6) + 1;
        int dice2 = randomGenerator.nextInt(6) + 1;
        System.out.printf("\nShooter rolled %d and %d", dice1, dice2);
        return dice1 + dice2;
    }
}
