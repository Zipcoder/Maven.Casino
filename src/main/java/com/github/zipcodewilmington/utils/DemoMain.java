package com.github.zipcodewilmington.utils;

import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import com.github.zipcodewilmington.casino.games.plinko.PlinkoGame;

public class DemoMain {
    public static void main(String[] args) {
        new BlackJackGame().run();
    }
}
