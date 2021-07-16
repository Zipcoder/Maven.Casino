package com.github.zipcodewilmington.casino.games.craps;

import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;


import static com.github.zipcodewilmington.casino.objects.Dice.roll;

public class CrapsTable {

    private final IOConsole console = new IOConsole(AnsiColor.CYAN);


    public void playCraps() {

        System.out.println("Shooter, Roll The Dice!");
        int score = roll();

        if (score == 7 || score == 11) {
            System.out.println("\nScore = " + score);
            System.out.println("\nNatural! You Win");


        } else if (score == 2 || score == 3 || score == 12) {
            System.out.println("\n Score = " + score);
            System.out.println("\nCraps! You Lose");


        } else {
            int point = score;
            System.out.println("\nPoint = " + point);
            while (true) {
                console.getStringInput("\nEnter 1 to roll again");
                //this.playerInput.nextLine();
                score = roll();

                System.out.println("\nNew Score = " + score);
                if (score == point) {

                    System.out.println("\nYou made your point, You Win");
                    break;
                }
                if (score == 7) {
                    System.out.println("\nYou rolled a 7, House Wins");
                    break;
                }
            }
        }
    }
}
