package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BlackJackPlayer implements PlayerInterface {
    private PlayerInterface player;

    public BlackJackPlayer(PlayerInterface player) {
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
