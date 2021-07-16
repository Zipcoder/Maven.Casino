package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;

public class MainApplication {
    public static void main(String[] args) {
        new Casino().run();

    }
}
