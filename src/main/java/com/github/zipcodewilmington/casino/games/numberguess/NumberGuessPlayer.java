package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessPlayer implements PlayerInterface {
    private PlayerInterface player;

    public NumberGuessPlayer(PlayerInterface player){
        this.player = player;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public void setArcadeAccount(CasinoAccount casinoAccount) {

    }
}