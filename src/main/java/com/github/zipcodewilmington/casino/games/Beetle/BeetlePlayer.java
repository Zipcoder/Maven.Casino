package com.github.zipcodewilmington.casino.games.Beetle;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BeetlePlayer implements PlayerInterface {
    private PlayerInterface player;

    public BeetlePlayer(PlayerInterface player){
        this.player = player;
    }


    public CasinoAccount getArcadeAccount() {
        return null;
    }

    public void setArcadeAccount(CasinoAccount casinoAccount) {

    }
}
