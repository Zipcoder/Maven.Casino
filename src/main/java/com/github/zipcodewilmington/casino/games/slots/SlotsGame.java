package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.sql.SQLOutput;
import java.util.*;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame implements GameInterface{//, PlayerInterface {

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public boolean playerWins() {
        return false;
    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    @Override
    public void clearGame() {

    }

    @Override
    public void run() {
        new SlotReels().playSlots();
    }

//    @Override
//    public CasinoAccount getArcadeAccount() {
//        return null;
//    }
//
//    @Override
//    public <SomeReturnType> SomeReturnType play() {
//        return null;
//    }
}



