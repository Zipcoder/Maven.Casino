package games;

import com.github.zipcodewilmington.casino.games.craps.CrapsGame;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrapsGameTest {
    CrapsGame caldronCraps = new CrapsGame();

    @Test
    public void passLineNaturalTest() {
        //Given

        int dice1 = 1;
        int dice2 = 6;
        int expectedScore = 7;

        //When
        caldronCraps.run();

        //Then
       //Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void passLineNaturalTest2() {
        //Given
        //CrapsGame caldronCraps = new CrapsGame();
        int dice1 = 2;
        int dice2 = 5;
        int expectedScore = 7;

        //When
        int actualScore = dice1 + dice2;

        //Then
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void passLineNaturalTest3() {
        //Given
       // CrapsGame caldronCraps = new CrapsGame();
        int dice1 = 3;
        int dice2 = 4;
        int expectedScore = 7;

        //When
        int actualScore = dice1 +dice2;

        //Then
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void passLineNaturalTest4() {
        //Given
        //CrapsGame caldronCraps = new CrapsGame();
        int dice1 = 5;
        int dice2 = 6;
        int expectedScore = 11;

        //When
        int actualScore = dice1 +dice2;

        //Then
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void passLineCrappedOutTest() {
        //Given
       // CrapsGame caldronCraps = new CrapsGame();
        int dice1 = 1;
        int dice2 = 1;
        int expectedScore = 2;

        //When
        int actualScore = dice1 +dice2;

        //Then
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void passLineCrappedOutTest2() {
        //Given
        //CrapsGame caldronCraps = new CrapsGame();
        int dice1 = 1;
        int dice2 = 2;
        int expectedScore = 3;

        //When
        int actualScore = dice1 +dice2;

        //Then
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void passLineCrappedOutTest3() {
        //Given
        //CrapsGame caldronCraps = new CrapsGame();
        int dice1 = 6;
        int dice2 = 6;
        int expectedScore = 12;

        //When
        int actualScore = dice1 +dice2;

        //Then
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void passLinePointTest() {
        //Given
        //CrapsGame caldronCraps = new CrapsGame();
        int dice1 = 2;
        int dice2 = 2;
        int expectedScore = 4;

        //When
        int actualScore = dice1 +dice2;

        //Then
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void passLinePointTest2() {
        //Given
       // CrapsGame caldronCraps = new CrapsGame();
        int dice1 = 3;
        int dice2 = 5;
        int expectedScore = 8;

        //When
        int actualScore = dice1 +dice2;

        //Then
        Assertions.assertEquals(expectedScore, actualScore);
    }

    @Test
    public void passLinePointTest3() {
        //Given
       // CrapsGame caldronCraps = new CrapsGame();
        int dice1 = 5;
        int dice2 = 5;
        int expectedScore = 10;

        //When
        int actualScore = dice1 +dice2;

        //Then
        Assertions.assertEquals(expectedScore, actualScore);
    }

}
