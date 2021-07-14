package com.github.zipcodewilmington.casino.games;

import java.util.HashSet;
import java.util.Set;

public abstract class RandomNumberGenerator {

    Integer maxNumber;
    Integer minNumber;
    Integer amountOfNumbers;

    public RandomNumberGenerator(Integer minNumber, Integer maxNumber, Integer amountOfNumbers) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.amountOfNumbers = amountOfNumbers;
    }

    public Integer generateRandomNumber() {
        Integer range = (maxNumber - minNumber) + 1;
        return (int)(Math.random() * range) + minNumber;
    }

    public Set<Integer> generateRandomNumbers() {
        Integer range = (maxNumber - minNumber) + 1;
        Set<Integer> setOfNumbers = new HashSet<>();
        Integer randomNumber = 0;
        while (setOfNumbers.size() < amountOfNumbers) {
            randomNumber = (int)(Math.random() * range) + minNumber;
            setOfNumbers.add(randomNumber);
        }
        return setOfNumbers;
    }
}
