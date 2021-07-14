package com.github.zipcodewilmington.casino;

/**
 * Author: Nathan
 * Date: 7/12/21
 */
public interface GameInterface extends Runnable {
    /**
     * adds a player to the game
     * @param player the player to be removed from the game
     */
    void add(PlayerInterface player);

    /**
     * removes a player from the game
     * @param player the player to be removed from the game
     */
    void remove(PlayerInterface player);

    /**
     * specifies how the game will run
     */
    void run();

    /**
     * Calculate player's winning payout amount of bet x multiplier
     * @return (double) amount of money winnings
     */
    Integer calculateWinnings(Integer multiplier, Integer betAmount);

    /**
     * Subtract the bet amount from player's balance
     */
    void subtractBetFromBalance(Integer betAmount);

    /**
     * Add winnings amount to player's balance
     */
    void addMoneyToBalance(PlayerInterface Player, Integer winnings);

}
