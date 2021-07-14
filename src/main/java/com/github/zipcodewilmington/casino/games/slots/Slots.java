package com.github.zipcodewilmington.casino.games.slots;

import java.util.HashMap;


public class Slots {
    private static final String[] slotItems = {"Peach", "Cherry", "Diamond", "Plum", "Seven", "Nine"};
    private String[][] slots = new String[3][3];
    private HashMap<Integer, String> winningLines = new HashMap<>();

    public Slots(String[][] slots) {
        //this.winningLines = new HashMap<>();
        this.slots = slots;
        initializeWinningLines();
    }

    public Slots(){
        //this.winningLines = new HashMap<>();
        this.slots = new String[][] {
                {"Peach", "Cherry", "Diamond"},
                {"Diamond", "Plum", "Nine"},
                {"Seven", "Peach", "Diamond"}};
        initializeWinningLines();
    }

    private void initializeWinningLines(){
        for (int i = 1; i < 9; i++) {
            winningLines.put(i, "LOSE");
        }
    }

    public String[][] getSlots() {
        return slots;
    }

    public void setSlots(String[][] slots) {
        this.slots = slots;
    }

    public HashMap<Integer, String> getWinningLines() {
        return winningLines;
    }

    public void spinSlots(){
        String[][] newSlot = new String[3][3];
        for (int a = 0; a < 3; a++) {
            newSlot[a][0] = ramdomSlotItem();
            newSlot[a][1] = ramdomSlotItem();
            newSlot[a][2] = ramdomSlotItem();
        }
        setSlots(newSlot);
    }

    public static String ramdomSlotItem(){
        int input = (int) ((Math.random() * (7 - 1)) + 1);
        String result;
        result = slotItems[input -1];
        return result;
    }

    public void setWinningLines(){
        String[][] currentSlots = this.getSlots();
        HashMap<Integer, String> newWinningLines = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            //setting horizontally
            if(currentSlots[i][0].equals(currentSlots[i][1]) && currentSlots[i][0].equals(currentSlots[i][2])){
                newWinningLines.put((i+1),"WIN");
            }
            //setting vertically
            if(currentSlots[0][i].equals(currentSlots[1][i]) && currentSlots[2][i].equals(currentSlots[i][2])){
                newWinningLines.put((i+4),"WIN");
            }
        }
        //setting diagonally
        if(currentSlots[0][0].equals(currentSlots[1][1]) && currentSlots[0][0].equals(currentSlots[2][2])){
            newWinningLines.put(7,"WIN");
        }
        if(currentSlots[2][2].equals(currentSlots[1][1]) && currentSlots[2][2].equals(currentSlots[0][0])){
            newWinningLines.put(8,"WIN");
        }
        this.winningLines = newWinningLines;
    }

    public String[] compareBetVsWinningLines(Integer[] bets){
        String[] result = new String[bets.length];
        for (int i = 0; i < bets.length; i++) {
            result[i] = winningLines.get(bets[i]);
        }
        return result;
    }




}
