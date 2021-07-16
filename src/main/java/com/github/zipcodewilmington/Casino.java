package com.github.zipcodewilmington;
import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.games.cards.BlackjackGame;
import com.github.zipcodewilmington.casino.games.cards.BlackjackPlayer;
import com.github.zipcodewilmington.casino.games.cards.TexasHoldEmGame;
import com.github.zipcodewilmington.casino.games.cards.TexasHoldEmPlayer;
import com.github.zipcodewilmington.casino.games.craps.CrapsGame;

//import com.github.zipcodewilmington.casino.games.games.craps.CrapsPlayer;

import com.github.zipcodewilmington.casino.games.craps.CrapsPlayer;

import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import com.github.zipcodewilmington.casino.games.keno.KenoPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private CasinoAccount currentAccount;
    private Player currentplayer;

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                //CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = this.currentAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if (gameSelectionInput.equals("SLOTS")) {
                        play(new SlotsGame(), new SlotsPlayer());
                    } else if (gameSelectionInput.equals("CRAPS")) {
                       //play(new CrapsGame(), new CrapsPlayer());
                    } else if (gameSelectionInput.equals("BLACKJACK")) {
                        play(new BlackjackGame(), new BlackjackPlayer());
                    } else if (gameSelectionInput.equals("KENO")) {
                        play(new KenoGame(), new KenoPlayer());
                    //} else if (gameSelectionInput.equals("ROULETTE")) {
                    //    play(new RouletteGame(), new RoulettePlayer());
                    } else if (gameSelectionInput.equals("TEXASHOLDEM")) {
                        play(new TexasHoldEmGame(), new TexasHoldEmPlayer());

                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "[ %s ] is an invalid game selection";
                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                }
            } else if ("new account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                this.currentAccount = newAccount;
                casinoAccountManager.registerAccount(newAccount);
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ new account ] [ game ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ CRAPS ], [ BLACKJACK ]" +
                        "\n\t [ KENO ], [ ROULETTE ], [ TEXASHOLDEM ]")

                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }
}
