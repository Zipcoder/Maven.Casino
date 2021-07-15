package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.*;
import com.github.zipcodewilmington.casino.games.Beetle.BeetleGame;
import com.github.zipcodewilmington.casino.games.blackjack.BlackJackGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.plinko.PlinkoGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.CSVUtils;
import com.github.zipcodewilmington.utils.IOConsole;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    private CasinoAccount casinoAccount;
    private PlayerInterface player;
    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {


                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    processGameSelection(gameSelectionInput);
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    //throw new RuntimeException(String.format(errorMessage, accountPassword, accountName));
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword);
                casinoAccountManager.registerAccount(newAccount);
                this.casinoAccount = newAccount;
                casinoAccount.alterAccountBalance(500);
                this.player = new Player(accountName, casinoAccount);
                this.player.setArcadeAccount(casinoAccount);
            } else if("save-account".equals(arcadeDashBoardInput)){
                try {
                    CSVUtils.csvFileSaver(this.player.getArcadeAccount());
                } catch (IOException e) {
                    e.printStackTrace();
                    console.println("Save unsuccessful, refer to error message above for more information");
                }
            } else if("load-saved-account".equals(arcadeDashBoardInput)){
                this.casinoAccount = CSVUtils.loadData();
                this.player = new Player(this.casinoAccount.getAccountName(), this.casinoAccount);
                casinoAccountManager.registerAccount(this.casinoAccount);
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ select-game ], [ load-saved-account ], [ save-account ]")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ NUMBERGUESS ], [ PLINKO ], [ BEETLE ], [ BLACKJACK ]" +
                        "[ KENO ]")
                .toString());
    }

    private void processGameSelection(String input){
        input = input.toLowerCase(Locale.ROOT);
        GameInterface gameObject;
        switch(input){
            case "beetle":
                gameObject = new BeetleGame();
                break;
            case "slots":
                gameObject = new SlotsGame();
                break;
            case "blackjack":
                gameObject = new BlackJackGame();
                break;
            case "numberguess":
                gameObject = new NumberGuessGame();
                break;
            default:
                gameObject = new BeetleGame();
        }

        play(gameObject, player);
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }
}
