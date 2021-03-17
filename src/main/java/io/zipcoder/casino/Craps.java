package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Craps{

    private Console c;
    private Scanner s;
    private Display d;
    private InputStream in;
    private PrintStream out;
    private Player player;
    private CrapsDisplay cd;

    private Integer input;
    private Integer innerInput;
    private Integer furtherInput;

    private Boolean[] outcomes;
    private Boolean[] bets;
    private Double[] betAmounts;
    private Double lastBet;

    public Craps(Player player){
        this.in = System.in;
        this.out = System.out;
        this.c = new Console(in, out);
        this.d = new Display();
        this.player = player;
        this.cd = new CrapsDisplay();

        this.input = 0;
        this.innerInput = 0;
        this.furtherInput = 0;

        this.outcomes = new Boolean[21];
        this.bets = new Boolean[21];
        this.betAmounts = new Double[21];
        this.lastBet = 0.0;

        for(int i = 0; i < 21; i++){
            outcomes[i] = false;
        }

        for(int i = 0; i < 21; i++){
            bets[i] = false;
        }

        for(int i = 0; i < 21; i++){
            betAmounts[i] = 0.0;
        }
    }

    /* *** Here is the index of every ***
       *** bet in the boolean arrays. ***
    0- pass
    1- don't pass
    2- come
    3- don't come
    4- field
    5- place bet 4
    6- place bet 5
    7- place bet 6
    8- place bet 8
    9- place bet 9
    10- place bet 10
    11- one-roll 7
    12- one-roll craps
    13- one-roll 6
    14- one-roll 8
    15- one-roll 4
    16- one-roll 10
    17- one-roll 3
    18- one-roll 11
    19- one-roll 2
    20- one-roll 12 */

    public void crapsEngine(){

        this.initialRulesPrompt();

        Boolean noPointSet = true;
        Boolean firstRoll = true;
        Boolean decisionUnmade = true;

        while(noPointSet){
            while(decisionUnmade) {
                cd.printSetTypeOfBet();
                input = c.getIntegerInput("Type 0 for no bet, 2 for 'pass,' 3 for 'don't pass,' or 4 for a proposition.");
                switch(input){
                    case 1:
                        cd.printRulesMenu1();
                        cd.printRulesMenuMid();
                        innerInput = c.getIntegerInput("Type 1 for yes, 2 for no.");
                        switch(innerInput){
                            case 1:
                                cd.printRulesMenu2();
                                break;
                            case 2:
                                break;
                        }
                        break;
                    case 2:
                        chooseBetAmountAndMakeBet(0);
                        break;
                    case 3:
                        chooseBetAmountAndMakeBet(1);
                        break;
                    case 0:
                        decisionUnmade = false;
                    case 4:
                        furtherInput = c.getIntegerInput("You can make a one roll bet. Type 2, 3, 4, 6, 8, 10, 11, or 12 to bet on that number, 1 for craps, or 0 to cancel.");
                        switch(furtherInput){
                            case 1:
                                chooseBetAmountAndMakeBet(12);
                                break;
                            case 2:
                                chooseBetAmountAndMakeBet(19);
                                break;
                            case 3:
                                chooseBetAmountAndMakeBet(17);
                                break;
                            case 4:
                                chooseBetAmountAndMakeBet(15);
                                break;
                            case 6:
                                chooseBetAmountAndMakeBet(13);
                                break;
                            case 8:
                                chooseBetAmountAndMakeBet(14);
                                break;
                            case 10:
                                chooseBetAmountAndMakeBet(16);
                                break;
                            case 11:
                                chooseBetAmountAndMakeBet(18);
                                break;
                            case 12:
                                chooseBetAmountAndMakeBet(20);
                                break;
                        }
                }
            }

        }


    }

    public void initialRulesPrompt(){
        cd.initalRulesAsk();
        Boolean haventAnswered = true;
        while(haventAnswered){
            input = c.getIntegerInput("Type 1 for yes, 2 for no.");
            switch(input) {
                case 1:
                    cd.printRulesMenu1();
                    cd.printRulesMenu2();
                    cd.readyToPlay();
                    haventAnswered = false;
                    break;
                case 2:
                    cd.readyToPlay();
                    haventAnswered = false;
                    break;
                default:
                    d.setPrintCurrentDisplay("Invalid user input. Please reread instructions.");
            }
        }
    }

    public void chooseBetAmountAndMakeBet(Integer x){
        Double middleMan;
        middleMan = c.getDoubleInput("How much money are you going to bet?");
        lastBet = player.makeBet(middleMan);
        betAmounts[x] = lastBet;
        bets[x] = true;
    }

}







