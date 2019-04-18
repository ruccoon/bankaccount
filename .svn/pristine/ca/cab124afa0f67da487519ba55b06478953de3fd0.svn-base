package com.cejv416.bankaccount;

import java.math.BigDecimal;

/**
 * subclass SavingAccount which extends the superclass BankAccount
 *
 * @author jfeng
 *
 */
public class SavingAccount extends BankAccount {

    private BigDecimal savingThreshold;
    private BigDecimal serviceFeeExtraWithdraw;
    private int allowWithdrawalsNum;

    public SavingAccount(BigDecimal start, BigDecimal annualRate) {

        super(start, annualRate);

    }

    public BigDecimal getSavingThreshold() {
        return savingThreshold;
    }

    public void setSavingThreshold(BigDecimal savingThreshold) {
        this.savingThreshold = savingThreshold;
    }

    public BigDecimal getServiceFeeExtraWithdraw() {
        return serviceFeeExtraWithdraw;
    }

    public void setServiceFeeExtraWithdraw(BigDecimal serviceFeeExtraWithdraw) {
        this.serviceFeeExtraWithdraw = serviceFeeExtraWithdraw;
    }

    public int getAllowWithdrawalsNum() {
        return allowWithdrawalsNum;
    }

    public void setAllowWithdrawalsNum(int allowWithdrawalsNum) {
        this.allowWithdrawalsNum = allowWithdrawalsNum;
    }

    /**
     * withdraw money from saving account
     *
     * @param amount
     * @return return response code
     *
     * 0, withdrawal successful 1, withdrawal failed due to Account is inactive
     * 2, (used for checking account) 3, withdrawal successful but account will
     * be inactive due to balance is below threshold 4, withdrawal failed due to
     * insufficient fund
     */
    @Override
    public int makeWithdraw(BigDecimal amount) {
        if (bb.isAccountStatus()) {
            BigDecimal tempBalance;

            tempBalance = bb.getCurrentBalance().subtract(amount);

            if (tempBalance.compareTo(BigDecimal.ZERO) != 1) {
                return 4; // insufficient fund to withdraw
            } else {

                super.makeWithdraw(amount);

                if (bb.getNumberOfWithdrawals() > allowWithdrawalsNum) {

                    bb.setCurrentBalance(bb.getCurrentBalance().subtract(serviceFeeExtraWithdraw));
                    bb.setServiceCharge(bb.getServiceCharge().add(serviceFeeExtraWithdraw));

                    //save the transaction
                    saveTrans("withdrawalFee", serviceFeeExtraWithdraw, 1);

                }

                //if (bb.getCurrentBalance()< savingThreshold) {
                if (bb.getCurrentBalance().compareTo(savingThreshold) == -1) {
                    bb.setAccountStatus(false);
                    return 3;

                    //System.out.println("Because account balance is below $25, the account will be inactive now.");

                }

                return 0;
            }
        } else {
            return 1;
            //System.out.println("Account is inactive, cannot make any withdraw until account balance is raised above $25.");
        }


    }

    /**
     * deposit money to saving account, and activate account if current status
     * is inactive and balance will be raised to threshold
     *
     * @param amount
     */
    @Override
    public void makeDeposit(BigDecimal amount) {
        super.makeDeposit(amount);
        if (!bb.isAccountStatus() && (bb.getCurrentBalance().compareTo(savingThreshold) == 1)) {
            bb.setAccountStatus(true);

            System.out.println(BankDB.INI_BANK_DEPOSIT_ABOVE_THRESHOLD);
        }
    }
// uncommend the following codes to test this class file
//    public static void main(String[] args) {
//
//        SavingAccount sa = new SavingAccount(new BigDecimal("100"), new BigDecimal("0.05"));
//        sa.bb.setAccountStatus(true);
//        sa.savingThreshold = new BigDecimal("25");
//        sa.serviceFeeExtraWithdraw = new BigDecimal("100");
//        sa.allowWithdrawalsNum = 4;
//        //System.out.println(sa.bb);
//        sa.makeWithdraw(new BigDecimal("95"));
//        sa.doMonthlyReport();
//    }
}
