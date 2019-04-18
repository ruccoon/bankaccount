package com.cejv416.bankaccount;

import java.math.BigDecimal;

/**
 * subclass CheckingAccount which extends the superclass BankAccount
 * 
 * @author jfeng
 *  
 */
public class CheckingAccount extends BankAccount {

    private BigDecimal checkingThreshold;
    private BigDecimal overDraftFee;
    private BigDecimal withdrawalSetupFee;
    private BigDecimal withdrawalFee;
    private boolean firstWithdrawal; //if it is first withdrawal, there is withdrawal setup fee charge

    public CheckingAccount(BigDecimal start, BigDecimal annualRate) {

        super(start, annualRate);

        firstWithdrawal = true;

    }

    public BigDecimal getCheckingThreshold() {
        return checkingThreshold;
    }

    public void setCheckingThreshold(BigDecimal checkingThreshold) {
        this.checkingThreshold = checkingThreshold;
    }

    public BigDecimal getOverDraftFee() {
        return overDraftFee;
    }

    public void setOverDraftFee(BigDecimal overDraftFee) {
        this.overDraftFee = overDraftFee;
    }

    public BigDecimal getWithdrawalSetupFee() {
        return withdrawalSetupFee;
    }

    public void setWithdrawalSetupFee(BigDecimal withdrawalSetupFee) {
        this.withdrawalSetupFee = withdrawalSetupFee;
    }

    public BigDecimal getWithdrawalFee() {
        return withdrawalFee;
    }

    public void setWithdrawalFee(BigDecimal withdrawalFee) {
        this.withdrawalFee = withdrawalFee;
    }

    public boolean isFirstWithdrawal() {
        return firstWithdrawal;
    }

    public void setFirstWithdrawal(boolean firstWithdrawal) {
        this.firstWithdrawal = firstWithdrawal;
    }

    /**
     * deposit money to checking account
     * 
     * @param amount 
     */
    @Override
    public void makeDeposit(BigDecimal amount) {
        super.makeDeposit(amount);
    }

    /**
     * withdraw money from checking account
     * 
     * 0, withdrawal successful
     * 1, (used for saving account)
     * 2, withdrawal failed due to insufficient fund, over draft fee charged
     * 3, (used for saving account)
     * 4, (used for saving account)
     * 
     * @param amount
     * @return return response code
     */
    @Override
    public int makeWithdraw(BigDecimal amount) {

        BigDecimal tempBalance;

        tempBalance = bb.getCurrentBalance().subtract(amount);

        if (tempBalance.compareTo(BigDecimal.ZERO) == -1) {
            // charge over draft fee due to insufficient fund
            bb.setCurrentBalance(bb.getCurrentBalance().subtract(getOverDraftFee()));
            bb.setServiceCharge(bb.getServiceCharge().add(getOverDraftFee()));

            //save the transaction
            saveTrans("withdrawFailed", amount, 0);
            saveTrans("overDraftFee", getOverDraftFee(), 1);

            return 2;
        } else {

            super.makeWithdraw(amount);

            if (firstWithdrawal) {
                bb.setCurrentBalance(bb.getCurrentBalance().subtract(getWithdrawalSetupFee()));
                bb.setServiceCharge(bb.getServiceCharge().add(getWithdrawalSetupFee()));

                //save the transaction
                saveTrans("withdrawalSetupFee", getWithdrawalSetupFee(), 1);

                firstWithdrawal = false;
            }

            bb.setCurrentBalance(bb.getCurrentBalance().subtract(getWithdrawalFee()));
            bb.setServiceCharge(bb.getServiceCharge().add(getWithdrawalFee()));

            saveTrans("withdrawalFee", getWithdrawalFee(), 1);

            return 0;
        }

    }

// uncommend the following codes to test this class file
//    public static void main(String[] args) {
//
//        CheckingAccount ca = new CheckingAccount(100000, 1);
//        ca.bb.setAccountStatus(true);
//        ca.setCheckingThreshold(0);
//        ca.setOverDraftFee(1500);
//        ca.setWithdrawalSetupFee(500);
//        ca.setWithdrawalFee(10);
//        //System.out.println(ca.bb);
//        ca.makeWithdraw(50000);
//        ca.makeWithdraw(20000);
//        ca.makeWithdraw(20000);
//        ca.makeWithdraw(20000);
//        ca.makeDeposit(11000);
//        ca.makeDeposit(11000);
//        ca.doMonthlyReport();
//    }
}
