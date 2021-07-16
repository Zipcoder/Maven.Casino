package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import org.junit.Assert;
import org.junit.Test;

public class SlotsGameTest {

    @Test
    public void slotsConstructorTest(){
        //when
        SlotsGame newGame = new SlotsGame();
        Assert.assertTrue(newGame instanceof SlotsGame);
    }

    @Test
    public void addPlayerTest(){
        //given
        SlotsGame newGame = new SlotsGame();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        //when
        newGame.add(player1);
        //then
        PlayerInterface retrievedPlayer = newGame.getCurrentPlayer();
        Assert.assertEquals(player1,retrievedPlayer );
    }

    @Test
    public void removePlayerTest(){
        //given
        SlotsGame newGame = new SlotsGame();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        //when
        newGame.add(player1);
        newGame.remove(newGame.getCurrentPlayer());
        //then
        PlayerInterface retrievedPlayer = newGame.getCurrentPlayer();
        Assert.assertNull(retrievedPlayer);
    }

    @Test
    public void calculateMultiplierTest(){
        //given
        SlotsGame newSlotsGame = new SlotsGame();
        String[] betResults = {"WIN", "WIN", "LOSE", "LOSE"};
        Integer expectedWin = 2;
        Integer expectedLose = 2;
        //when
        newSlotsGame.calculateMultiplier(betResults);
        Integer retrievedWin = newSlotsGame.getWinMultiplier();
        Integer retrievedLose = newSlotsGame.getLoseMultiplier();
        //then
        Assert.assertEquals(expectedWin, retrievedWin);
        Assert.assertEquals(expectedLose, retrievedLose);

    }

    @Test
    public void calculateWinningsTest(){
        //given
        SlotsGame newGame = new SlotsGame();
        Integer expected = 10;
        //when
        Integer actual = newGame.calculateWinnings(2, 5);
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateReturnTotal(){
        //given
        SlotsGame newGame = new SlotsGame();
        newGame.setBetTotal(80);
        Integer expected = 100;
        //when
        Integer actual = newGame.calculateReturnTotal(50, 30);
        //then
        Assert.assertEquals(expected, actual);

    }


    @Test
    public void printWelcomeTest(){
        //given
        SlotsGame slotGame = new SlotsGame();
        //when
        slotGame.printWelcome();
        //confirm with printout
    }

    @Test
    public void subtractBetFromBalanceTest(){
        //given
        SlotsGame slotGame = new SlotsGame();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        slotGame.add(player1);
        //when
        slotGame.subtractBetFromBalance(50);
        Integer expected = 50 * (-1);
        Integer retrieved = player1.getArcadeAccount().getAccountBalance();
        //then
        Assert.assertEquals(expected, retrieved);

    }

    @Test
    public void addMoneyToBalanceTest(){
        //given
        SlotsGame slotGame = new SlotsGame();
        CasinoAccount account = new CasinoAccount("name", "password");
        Player player1 = new Player(null, account);
        slotGame.add(player1);
        //when
        slotGame.addMoneyToBalance(player1, 50);
        Integer expected = 50;
        Integer retrieved = player1.getArcadeAccount().getAccountBalance();
        //then
        Assert.assertEquals(expected, retrieved);
    }

    @Test
    public void setBetTotal(){
        //given
        SlotsGame slotGame = new SlotsGame();
        //when
        slotGame.setBetTotal(50);
        Integer expected = 50;
        Integer retrieved = slotGame.getBetTotal();
        //
        Assert.assertEquals(expected, retrieved);
    }
}
