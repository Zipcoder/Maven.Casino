package io.zipcoder.casino;

public class Main {

    public static void main(String args[]) {
        Display d = new Display();
        GoFishEngine play = new GoFishEngine();
        play.startGame();
    }
}
