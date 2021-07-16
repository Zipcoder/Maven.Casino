package com.github.zipcodewilmington.casino.games.slots;


import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.*;

public class SlotReels {


    private static String BROOMSTICK = "BROOMSTICK";
    private static String GOLDENSNITCH = "GOLDENSNITCH";
    private static String DOBBYSSOCK = "DOBBYSSOCK";


    // Making randomizer //
    static List<String> reelValue = Collections.unmodifiableList(Arrays.asList(BROOMSTICK, GOLDENSNITCH, DOBBYSSOCK));
    static int size = reelValue.size();
    static Random randomizer = new Random();


    public void playSlots() {
        //Random randomizer = new Random();
        final IOConsole console = new IOConsole(AnsiColor.WHITE);
        Scanner scanner = new Scanner(System.in);

        int playerInput = 0; // research how to use enums to substitute for numbers
        float playerReward = 0; // non gambling game, if player wins they get a few cents towards their account balance?
        String slot1;  // Dobby's Sock
        String slot2; // Broom Stick
        String slot3; // Golden Snitch

        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
        System.out.println("~~~                           ~~~");
        System.out.println("~ WELCOME TO DOBBY'S SOCK SLOTS ~");
        System.out.println("~~~                           ~~~");
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
        System.out.println("                                 ");
        //System.out.println("How lucky are you?\n" +
        //"Total Rewards: " + playerReward);

        // Pull lever!
        do {
            System.out.println("ENTER 1 to PULL THE LEVER\n" +
                    "ENTER 2 to QUIT GAME"); // throw exceptions if they try to break game
            System.out.println("                             ");
            System.out.println("TOTAL REWARDS: " + playerReward + "\n>");

            playerInput = scanner.nextInt();

            if(playerInput == 2) {
                System.out.println("~*~ DOBBY SAYS... THANK YOU FOR PLAYING MY SOCK SLOTS ~*~");
                System.out.println("                              ");
                System.out.println("TOTAL REWARDS: $$$ ~ " + playerReward + " ~ $$$");
                System.out.println("                              ");
                break;
            }

            slot1 = reelValue.get(randomizer.nextInt(size));
            slot2 = reelValue.get(randomizer.nextInt(size));
            slot3 = reelValue.get(randomizer.nextInt(size));

            System.out.println("                                                  ");
            //System.out.println("  -------------  -----------   -----------");
            System.out.println(" | " + slot1 + " | " + slot2 + " | " + slot3 + " | ");
            //System.out.println("  -------------  -----------   -----------");
            System.out.println("                                                  ");

            // Game Sequence

            if (slot1.equals(slot2) && slot1.equals(slot3)) {
                System.out.println("$$$ ~ YOU WIN 50 Cents ~ $$$");
                System.out.println("                                      ");
                playerReward += 0.50;

            } else if (slot1.equals(slot2) || slot1.equals(slot3) || slot2.equals(slot3)) {
                System.out.println("$$$ ~ YOU WIN 25 Cents ~ $$$");
                System.out.println("                                     ");
                playerReward += 0.25;

            } else {
                System.out.println(":( NO LUCK... DOBBY SAYS TRY AGAIN ! :)");
                System.out.println("                                        ");
            }
        }
        while (playerInput == 1);

//        System.out.println("TOTAL REWARDS: " + playerReward);
//        System.out.println("                              ");
    }
}