

package com.github.zipcodewilmington.casino.games.roulette;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingPlayer;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.objects.RouletteBet;


public class RoulettePlayer implements GamblingPlayer {

    Player player;
    float playerWinnings;

    public RoulettePlayer() {
        
    }


    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }

    public boolean finalizeBet() {
        return false;
    }


    @Override
    public void increaseBet(float raise) {
        player.setCurrentBet(player.getCurrentBet() + raise);
        player.setBalance(player.getBalance() - raise);
    }


    @Override
    public void decreaseBet(float deposit) {
        player.setCurrentBet(player.getCurrentBet()-deposit);
        player.setBalance(player.getBalance()+deposit);
    }

    @Override
        public float amountWagered () {

        return 0;
    }

    @Override
        public float amountWon () {
        return 0;
    }

        @Override
        public float payOut () {
            return 0;
        }



}

