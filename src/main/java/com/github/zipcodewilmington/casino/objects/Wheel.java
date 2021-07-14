package com.github.zipcodewilmington.casino.objects;

import java.util.List;

public class Wheel {

    int numberOfPositions;

    public Wheel(){
        this.numberOfPositions = 37;
    }

    public int getSpinValue(){
        return (int) (Math.random() * numberOfPositions); //European wheel with one 0 value
    }

}
