package com.cejv416.bankaccount;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * this class is to encapsulate the basic members of a bank account
 * 
 * @author jfeng
 *
 */
public class BankBean {

    private BigDecimal startingBalance;
    private BigDecimal currentBalance;
    private BigDecimal totalDeposits;
    private int numberOfDeposits;
    private BigDecimal totalWithdrawals;
    private int numberOfWithdrawals;
    private BigDecimal annualInterestRate;
    private BigDecimal serviceCharge;
    private boolean accountStatus;
    private BigDecimal monthlyInterest;
    private int accountType; //1: saving, 2: checking
    private ArrayList<String[]> trans;//to store the transaction details, {description, withdraw, deposit, balance, newTrans}

    public BankBean() {
        super();
        // initial data
        startingBalance = new BigDecimal("0");
        currentBalance = new BigDecimal("0");
        totalDeposits = new BigDecimal("0");
        numberOfDeposits = 0;
        totalWithdrawals = new BigDecimal("0");
        numberOfWithdrawals = 0;
        annualInterestRate = new BigDecimal("0");
        serviceCharge = new BigDecimal("0");
        accountStatus = false;
        monthlyInterest = new BigDecimal("0");
        accountType = 0;

        trans = new ArrayList<String[]>();
    }

    public BigDecimal getStartingBalance() {
        return startingBalance;
    }

    public void setStartingBalance(BigDecimal startingBalance) {
        this.startingBalance = startingBalance;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getTotalDeposits() {
        return totalDeposits;
    }

    public void setTotalDeposits(BigDecimal totalDeposits) {
        this.totalDeposits = totalDeposits;
    }

    public int getNumberOfDeposits() {
        return numberOfDeposits;
    }

    public void setNumberOfDeposits(int numberOfDeposits) {
        this.numberOfDeposits = numberOfDeposits;
    }

    public BigDecimal getTotalWithdrawals() {
        return totalWithdrawals;
    }

    public void setTotalWithdrawals(BigDecimal totalWithdrawals) {
        this.totalWithdrawals = totalWithdrawals;
    }

    public int getNumberOfWithdrawals() {
        return numberOfWithdrawals;
    }

    public void setNumberOfWithdrawals(int numberOfWithdrawals) {
        this.numberOfWithdrawals = numberOfWithdrawals;
    }

    public BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(BigDecimal annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public BigDecimal getServiceCharge() {
        return serviceCharge;
    }

    public void setServiceCharge(BigDecimal serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public boolean isAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(boolean accountStatus) {
        this.accountStatus = accountStatus;
    }

    public BigDecimal getMonthlyInterest() {
        return monthlyInterest;
    }

    public void setMonthlyInterest(BigDecimal monthlyInterest) {
        this.monthlyInterest = monthlyInterest;
    }

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeValue() {
        switch (getAccountType()) {
            case 0:
                return "Saving";
            case 1:
                return "Checking";
            default:
                return "wrong account";
        }
    }

    public ArrayList<String[]> getTrans() {
        return trans;
    }

    public void setTrans(ArrayList<String[]> trans) {
        //the following code doesn't work, it will reference to the same object
        //this.trans = trans;
        this.trans.addAll(trans);
    }

    /**
     * override toString() for debug
     * @return return all fields value as String
     */
    @Override
    public String toString() {
        return "startingBalance:" + startingBalance + "\n"
                + "currentBalance:" + currentBalance + "\n"
                + "totalDeposits:" + totalDeposits + "\n"
                + "numberOfDeposits:" + numberOfDeposits + "\n"
                + "totalWithdrawals:" + totalWithdrawals + "\n"
                + "numberOfWithdrawals:" + numberOfWithdrawals + "\n"
                + "annualInterestRate:" + annualInterestRate + "\n"
                + "serviceCharge:" + serviceCharge + "\n"
                + "accountStatus:" + accountStatus + "\n"
                + "monthlyInterest:" + monthlyInterest + "\n"
                + "accountType:" + accountType;
    }
}
