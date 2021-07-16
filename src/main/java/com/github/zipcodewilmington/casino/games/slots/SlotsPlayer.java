package com.github.zipcodewilmington.casino.games.slots;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by Nathan on 7/14/2021.
 */
public class SlotsPlayer implements PlayerInterface  {
    private PlayerInterface player;

    public SlotsPlayer(PlayerInterface player){
        this.player = player;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return player.getArcadeAccount();
    }

    @Override
    public void setArcadeAccount(CasinoAccount casinoAccount) {

    }
}