package com.github.zipcodewilmington.casino;

import java.util.List;
import java.util.Map;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    String accountName;
    String AccountPassword;
    String house;
    float balance;



    public CasinoAccount(String accountName, String getAccountPassword) {
        this.accountName = accountName;
        this.AccountPassword = getAccountPassword;

    }

    public CasinoAccount(String accountName, String accountPassword, float balance) {
        this.accountName = accountName;
        AccountPassword = accountPassword;
        this.balance = balance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return AccountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        AccountPassword = accountPassword;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
