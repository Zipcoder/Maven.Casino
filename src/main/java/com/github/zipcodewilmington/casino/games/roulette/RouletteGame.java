
package com.github.zipcodewilmington.casino.games.roulette;
import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.PlayerInterface;


import com.github.zipcodewilmington.casino.objects.RouletteBet;
import com.github.zipcodewilmington.casino.objects.Wheel;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RouletteGame implements GambleableGame {

    public static void main(String[] args) {
        RouletteGame game = new RouletteGame();
        game.run();
    }

    String gameName;
    Wheel wheel;
    RoulettePlayer player;
    RouletteBet bet = new RouletteBet();
    int streetBet;
    int singleBet;
    int columnBet;
    int evenBet;
    int oddBet;
    int winningNum;

    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);


    public RouletteGame(String gameName, RoulettePlayer player, Wheel wheel) {
        this.gameName = gameName;
        this.player = player;
        this.wheel = new Wheel();

    }

    public RouletteGame(){
        this.gameName = "Rowena's Roulette";
        this.player = new RoulettePlayer();
        this.wheel = new Wheel();
        this.bet = new RouletteBet();
    }


    @Override
    public void run() {
        console.println("Welcome to %s !", gameName);
        console.println("Place your bet!");
        console.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*");
        console.getStringInput("Select Inside or Outside");
        console.println("Scared, Potter?");
        String betSelectionInput = getBetSelection().toUpperCase();
        if (betSelectionInput.equals("INSIDE")) {
            String insideBet = selectStreetorSingle().toUpperCase();
            if (insideBet.equals("STREET")) {
                selectStreetNumber();
                spinWheel();
                Integer[] check = bet.winningStreetArray(streetBet); //check array
                console.println(getWinningString(check));
                console.println("-----------0v0------------");
                exitCode();
            } else {
                selectSingleNumber();
                spinWheel();
                console.println(getWinningString(singleBet));

            }
        }
        if (betSelectionInput.equals("OUTSIDE")){
            String outsideBet = getOutBetSelection().toUpperCase();
            switch (outsideBet){
                case "COLUMN":
                    selectColumnNumber();
                    spinWheel();
                    Integer[] column = bet.winningColumn(columnBet);
                    console.println(getWinningColumnPhrase(column));
                    console.println("-----------0v0------------");
                    exitCode();
                    break;
                case "EVEN" :
                    spinWheel();
                    console.println(getWinningEvenPhrase());
                    console.println("-----------0v0------------");
                    exitCode();
                    break;
                case "ODD" :
                    spinWheel();
                    console.println(getWinningOddPhrase());
                    console.println("-----------0v0------------");
                    exitCode();
                    break;
                default:
                    break;

            }
            run();
            placeBet();
        }





    }
    public String exitCode(){
        return console.getStringInput(new StringBuilder()
                .append("Care to play again?")
                .append(" Y / N ")
                .toString());
    }

    public void spinWheel(){
        console.println("Spinning...");
        int winningNumber = wheel.getSpinValue();
        this.winningNum = winningNumber;
    }



    public String getBetSelection(){
        return console.getStringInput(new StringBuilder()
                .toString());
    }
    public String getOutBetSelection(){
        return console.getStringInput(new StringBuilder()
                .append("Options: Column, Even, or Odd")
            .toString());
    }

    public String selectStreetorSingle(){
        return console.getStringInput("Street or Single");
    }

    public void selectStreetNumber(){
        this.streetBet = console.getIntegerInput("Pick Your Number");

    }

    public void selectSingleNumber(){
        this.singleBet = console.getIntegerInput("Pick Your Number");
    }

    public void selectColumnNumber() {
        this.columnBet = console.getIntegerInput("Pick Your Number");
    }

    public double placeBet(){
        String input = console.getStringInput("How much?");
        return Double.parseDouble(input);

    }

    public String getWinningString(Integer[] win){
        List<Integer> winArray = new ArrayList<Integer>(Arrays.asList(win));
        if (winArray.contains(winningNum)){
            return "Merlin's Beard! You WIN!" ;
        }
        return "Avada Kadavra! You're done.";
    }

    public String getWinningString(Integer win){
        if (singleBet == winningNum){
            return "Felix Felicus! You WIN!" ;
        }
        return "Wingardium, you lose.";
    }

    public String getWinningColumnPhrase(Integer[] win){
        List<Integer> winArray = new ArrayList<Integer>(Arrays.asList(win));
        if (winArray.contains(winningNum)){
            return "Felix Felicus! You WIN!" ;
        }
        return "Riddikulus! Be gone!";
    }

    public  String getWinningEvenPhrase(){
        if (winningNum % 2 == 0) {
            return "Enchanting! You've won";
        }
        return "Expelliarmus! You're done";
    }

    public  String getWinningOddPhrase(){
        if (winningNum % 2 == 1) {
            return "Enchanting! You've won";
        }
        return "Accio Funds! You're done!";
    }

    @Override
    public void clearGame() {

    }
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

        //return (userInput == wheel.getSpinValue());
        return false;

    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    public int evaluateInsideBet(int bet){
        return 0;


    }


}
