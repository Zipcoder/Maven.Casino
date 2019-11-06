package io.zipcoder.casino.Menus;


import io.zipcoder.casino.CasinoArt;
import io.zipcoder.casino.Games.Blackjack.BlackJack;
import io.zipcoder.casino.Games.Craps.Craps;
import io.zipcoder.casino.Games.Roulette.Roulette;
import io.zipcoder.casino.Games.SnakesAndLadders.SnakesAndLadders;
import io.zipcoder.casino.Games.HighAndLow.HighAndLow;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.Games.Slots.Slots;
import io.zipcoder.casino.utilities.Console;

public class GameMenu {
    private Console console = new Console(System.in, System.out);
    private Integer playerInput;
    private Player currentPlayer;
    private CasinoArt art = new CasinoArt();
    private boolean running = true;

    public void runGameMenu(Player currentPlayer){
        this.currentPlayer = currentPlayer;
        while(running) {
            Console.clearScreen();
            console.println(art.getCasinoArt(CasinoArt.Art.GAMEMENU));
            Console.displayGameMenu();
            Integer playerInput = getPlayerInput();
            gameMenuLogic(playerInput);
        }
    }

    public Integer getPlayerInput(){
        this.playerInput = console.getIntegerInput(":");
        return playerInput;
    }

    public String gameMenuLogic(Integer playerInput){
        switch (playerInput) {
            case 1:
                console.print("You would be playing Go Fish now.");
                /*GoFish goFish = new GoFish();
                goFish.launchGoFish();*/
                return "You would be playing Go Fish now.";
            case 2:

                BlackJack blackjack = new BlackJack();
                blackjack.runBlackJack(currentPlayer);
                break;
            case 3:
                Craps craps = new Craps();
                craps.approachTable(currentPlayer);
                return "You would be playing craps now.";
            case 4:
                SnakesAndLadders SnakesAndLadders = new SnakesAndLadders();
                SnakesAndLadders.runSnakesAndLadders(currentPlayer);
                return "You would be playing Snakes and Ladders now.";
            case 5:
                Roulette roulette = new Roulette();
                roulette.runRoulette(currentPlayer);
                return "You would be playing Roulette now.";
            case 6:
                Slots slots = new Slots();
                slots.runSlots(currentPlayer);
                return "You would be playing SlotMachine now";
            case 7:
                HighAndLow highAndLow = new HighAndLow();
                highAndLow.runHighOrLow(currentPlayer);
                return "You would be playing High and Low now.";
            case 8:
                running = false;
                break;
// shouldn't we be calling casino menu here?
        }
        return null;
    }
}

