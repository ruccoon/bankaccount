package com.cejv416.bankaccount;

import java.text.NumberFormat;

/**
 * this is the main Bank application
 * 
 * @author jfeng
 */
public class BankApp {

    // declare saving & checking account variables
    private SavingAccount sa;
    private CheckingAccount ca;
    // declare inputOutput variable
    private InputOutput io;
    
    /**
     * constructor
     * initial saving account, checking account and inputoutput to display bank menu
     */
    public BankApp() {

        super();

        InitialSaving();

        InitialChecking();

        io = new InputOutput(sa, ca);

        // start to display the bank menu
        io.perform();
    }

    /**
     * initial saving account
     */
    private void InitialSaving() {

        sa = new SavingAccount(BankDB.INI_SAVING_BALANCE, BankDB.INI_SAVING_RATE);
        sa.bb.setAccountStatus(BankDB.INI_SAVING_ACCOUNT_STATUS);
        sa.setSavingThreshold(BankDB.INI_SAVING_THRESHOLD);
        sa.setAllowWithdrawalsNum(BankDB.INI_SAVING_ALLOW_WITHDRAWALS_NUM);
        sa.setServiceFeeExtraWithdraw(BankDB.INI_SAVING_EXTRA_WITHDRAW_FEE);
        sa.bb.setAccountType(0);//saving account
    }

    /**
     * initial checking account
     */
    private void InitialChecking() {

        ca = new CheckingAccount(BankDB.INI_CHECKING_BALANCE, BankDB.INI_CHECKING_RATE);
        ca.bb.setAccountStatus(BankDB.INI_CHECKING_ACCOUNT_STATUS);
        ca.setCheckingThreshold(BankDB.INI_CHECKING_THRESHOLD);
        ca.setOverDraftFee(BankDB.INI_CHECKING_OVER_DRAFT_FEE);
        ca.setWithdrawalSetupFee(BankDB.INI_CHECKING_WITHDRAWAL_SETUP_FEE);
        ca.setWithdrawalFee(BankDB.INI_CHECKING_WITHDRAWAL_FEE);
        ca.bb.setAccountType(1);//checking account
    }

    /**
     * the main method to instantiate BankApp object
     * @param args 
     */
    public static void main(String[] args) {
        BankApp ba = new BankApp();

        System.exit(0);
    }
}
