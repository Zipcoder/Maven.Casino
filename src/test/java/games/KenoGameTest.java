package games;

import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class KenoGameTest {
    KenoGame kGame = new KenoGame();

    @Test
   public void guessNumbers() {

        ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80));
        ArrayList<Integer> actual;


      actual = kGame.guessNumbers();
      Assert.assertEquals(expected,actual);

    }

    @Test
    public void userInputTest(){
        int[] expected = {17,24,73,80,34,51,11,28,33,71,45,15,31,22,3,10,1,8,4,20};
        int[] actual = kGame.userInput();

        Assert.assertEquals(expected,actual);
    }
    @Test
    public void isUniqueTest(){
        int[] i = {5,4,3,2,9,8,7,6,10};

        boolean expected = true;
        boolean actual = kGame.isUnique(1,i);
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void getComputerNumTest(){

        //int[] expected = {30,22,42,10,21,13,38,74,29,11,27,20,17,44,55,52,76,80,15,77};
        int[] actual;

        actual = kGame.getComputerNum();
        Assert.assertNotNull(actual);
    }
    @Test
    public void getCatchTest(){

        int[] playerNumber = {23,49,45};
        int[] computerNumber = {64,49,45};
        int expected = 2;
        int actual = kGame.getCatch(playerNumber,computerNumber);
        Assert.assertEquals(expected,actual);
    }


}