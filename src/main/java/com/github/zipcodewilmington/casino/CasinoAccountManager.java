package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
        List<CasinoAccount> accountList = new ArrayList<CasinoAccount>();

    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        CasinoAccount casinoAccount = new  CasinoAccount(accountName, accountPassword);
        int findIndex = accountList.indexOf(casinoAccount);
        return accountList.get(findIndex);
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {
            CasinoAccount newAccount = new CasinoAccount(accountName, accountPassword);
            return newAccount;
    }

    public List<CasinoAccount> getCasinoAccountList(){
        return accountList;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
       this.getCasinoAccountList().add(casinoAccount);

    }
}
