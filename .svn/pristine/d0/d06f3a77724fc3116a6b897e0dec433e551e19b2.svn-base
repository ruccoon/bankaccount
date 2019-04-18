package com.cejv416.bankaccount;

import java.math.BigDecimal;

/**
 * This class include all constants
 * 
 * @author jfeng
 * * 
 */
public class BankDB {
    //initial all members for saving account
    public static final BigDecimal INI_SAVING_BALANCE = BigDecimal.ZERO;
    public static final BigDecimal INI_SAVING_RATE = new BigDecimal("0.05");
    public static final boolean INI_SAVING_ACCOUNT_STATUS = false;
    public static final BigDecimal INI_SAVING_THRESHOLD = new BigDecimal("25");
    public static final int INI_SAVING_ALLOW_WITHDRAWALS_NUM = 4;
    public static final BigDecimal INI_SAVING_EXTRA_WITHDRAW_FEE = new BigDecimal("1");

    //initial all members for checking account
    public static final BigDecimal INI_CHECKING_BALANCE = BigDecimal.ZERO;
    public static final BigDecimal INI_CHECKING_RATE = new BigDecimal("0.00001");
    public static final boolean INI_CHECKING_ACCOUNT_STATUS = true;
    public static final BigDecimal INI_CHECKING_THRESHOLD = BigDecimal.ZERO;
    public static final BigDecimal INI_CHECKING_OVER_DRAFT_FEE = new BigDecimal("15");
    public static final BigDecimal INI_CHECKING_WITHDRAWAL_SETUP_FEE = new BigDecimal("5");
    public static final BigDecimal INI_CHECKING_WITHDRAWAL_FEE = new BigDecimal("0.1");
    
    //initial bank menu input
    public static final String INI_BANK_MENU_SELECT = "Please select menu: ";
    public static final String INI_BANK_MENU_SELECT_AGAIN = "Please select menu again: ";
    public static final String INI_BANK_MENU_INPUT = "Please input amount: ";
    public static final String INI_BANK_MENU_INPUT_AGAIN = "Invalid amount, please input amount again: ";
    public static final String INI_BANK_MENU_ENTER_CONTINUE = "Press Enter key to continue: ";
    
    //initial transaction response
    public static final String INI_BANK_DEPOSIT_SUCCESS = "The amount has been deposited to your account: ";
    public static final String INI_BANK_DEPOSIT_ABOVE_THRESHOLD = "The account balance is above the threshold $25, and the account status is active now!";
    public static final String INI_BANK_WITHDRAWAL_SUCCESS = "The amount has been withdrawed from your account: "; //0
    public static final String INI_BANK_WITHDRAWAL_FAIL = "Sorry, you cannot make any withdrawal due to your account is inactive status.";//1
    public static final String INI_BANK_WITHDRAWAL_OVERDRAFT = "Sorry, withdrawal failed. There is over draft fee $15 charged due to insufficient fund in your account.";//2
    public static final String INI_BANK_WITHDRAWAL_BELOW_THRESHOLD = "The account balance is below the threshold $25, and the account statuc is inactive now!";//3
    public static final String INI_BANK_WITHDRAWAL_INSUFFICIENT = "Sorry, withdrawal failed. There is insufficient fund in your account.";//4
    
    //initial report tabel cell length
    //description, withdraw, deposit, balance
    public static final int INI_REPORT_DESCRIPTION_LENGTH = 25;
    public static final int INI_REPORT_DEBIT_LENGTH = 20;
    public static final int INI_REPORT_CREDIT_LENGTH = 20;
    public static final int INI_REPORT_BALANCE_LENGTH = 20;
    
    public static int reportTableLength = BankDB.INI_REPORT_DESCRIPTION_LENGTH
            + BankDB.INI_REPORT_DEBIT_LENGTH
            + BankDB.INI_REPORT_CREDIT_LENGTH
            + BankDB.INI_REPORT_BALANCE_LENGTH;
    

    public BankDB() {
        super();
    }
}
