package com.cejv416.bankaccount;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * this class is super class, it includes all basic functions
 *
 * @author jfeng
 *
 */
public abstract class BankAccount {

    protected BankBean bb;
    NumberFormat nf;

    /**
     * constructor <p> initial starting balance and annual interest rate from
     * parameters
     *
     * @param start
     * @param annualRate
     */
    public BankAccount(BigDecimal start, BigDecimal annualRate) {

        super();

        bb = new BankBean();
        bb.setStartingBalance(start);
        bb.setCurrentBalance(start);
        bb.setAnnualInterestRate(annualRate);

        nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
    }

    /**
     * deposit money to bank account<p> increment total number of deposits &
     * total deposits amount<p> save transaction log<p> display deposit message
     *
     * @param amount
     */
    public void makeDeposit(BigDecimal amount) {
        bb.setTotalDeposits(bb.getTotalDeposits().add(amount, MathContext.DECIMAL128));
        bb.setNumberOfDeposits(bb.getNumberOfDeposits() + 1);

        bb.setCurrentBalance(bb.getCurrentBalance().add(amount));

        //save the transaction details
        saveTrans("deposit", amount, 0);

        System.out.println("\n" + BankDB.INI_BANK_DEPOSIT_SUCCESS + NumberFormat.getCurrencyInstance().format(amount));

    }

    /**
     * withdraw money from bank account<p> increment total number of withdrawals
     * & total withdrawals amount<p> save transaction log
     *
     * @param amount
     */
    public int makeWithdraw(BigDecimal amount) {
        bb.setTotalWithdrawals(bb.getTotalWithdrawals().add(amount));
        bb.setNumberOfWithdrawals(bb.getNumberOfWithdrawals() + 1);

        bb.setCurrentBalance(bb.getCurrentBalance().subtract(amount));

        //save the transaction details
        saveTrans("withdraw", amount, 0);

        return 0;
    }

    /**
     * calculate the interest and update to current balance amount<p> this
     * method will be called before running report
     */
    private void calculateInterest() {
        BigDecimal monthlyRate = bb.getAnnualInterestRate().divide(new BigDecimal("12"), MathContext.DECIMAL128);
        //BigDecimal monthlyRate = bb.getAnnualInterestRate().divide(new BigDecimal("12"), 10, RoundingMode.HALF_UP);

        if (bb.getCurrentBalance().compareTo(BigDecimal.ZERO) == 1) {
            bb.setMonthlyInterest(bb.getCurrentBalance().multiply(monthlyRate));
        } else {
            bb.setMonthlyInterest(new BigDecimal("0"));
        }
        bb.setCurrentBalance(bb.getCurrentBalance().add(bb.getMonthlyInterest()));
    }

    /**
     * calculate monthly interest<p> DEEP copy the current BankBean and return
     * for statement output<p> zero out current BankBean except to set starting
     * balance as current balance for next month usage
     */
    public BankBean doMonthlyReport() {

        // calculate interest
        calculateInterest();

        // make a copy of BankBean for output statement
        BankBean reportBB = new BankBean();
        reportBB.setAccountStatus(bb.isAccountStatus());
        reportBB.setAnnualInterestRate(bb.getAnnualInterestRate());
        reportBB.setAccountType(bb.getAccountType());
        reportBB.setCurrentBalance(bb.getCurrentBalance());
        reportBB.setMonthlyInterest(bb.getMonthlyInterest());
        reportBB.setNumberOfDeposits(bb.getNumberOfDeposits());
        reportBB.setNumberOfWithdrawals(bb.getNumberOfWithdrawals());
        reportBB.setServiceCharge(bb.getServiceCharge());
        reportBB.setStartingBalance(bb.getStartingBalance());
        reportBB.setTotalDeposits(bb.getTotalDeposits());
        reportBB.setTotalWithdrawals(bb.getTotalWithdrawals());
        reportBB.setTrans(bb.getTrans());

        // zero out bank data
        bb.setMonthlyInterest(new BigDecimal("0"));
        bb.setNumberOfDeposits(0);
        bb.setNumberOfWithdrawals(0);
        bb.setServiceCharge(new BigDecimal("0"));
        bb.setTotalDeposits(new BigDecimal("0"));
        bb.setTotalWithdrawals(new BigDecimal("0"));
        // put current balance to next month's starting balance
        bb.setStartingBalance(bb.getCurrentBalance());

        bb.getTrans().clear();

        return reportBB;

    }

    /**
     * save transaction details to String[] <p>
     *
     * {Description, Debit, Credit, Balance, newTrans}
     *
     *
     * @param transType
     * @param amount
     * @param newTrans 0 stands for new transaction; 1 stands for NOT new
     * transaction, usually to log service fee
     *
     */
    public void saveTrans(String transType, BigDecimal amount, int newTrans) {

        String[] transDetails = new String[5];

        switch (transType) {
            case "deposit":
                transDetails[0] = Table.fixCellLength(" Deposit", 'l', BankDB.INI_REPORT_DESCRIPTION_LENGTH); //description
                transDetails[1] = Table.fixCellLength(" ", 'r', BankDB.INI_REPORT_DEBIT_LENGTH); // debit
                transDetails[2] = Table.fixCellLength(nf.format(amount), 'r', BankDB.INI_REPORT_CREDIT_LENGTH); // credit
                transDetails[3] = Table.fixCellLength(nf.format(bb.getCurrentBalance()) + " ", 'r', BankDB.INI_REPORT_BALANCE_LENGTH); // account balance
                transDetails[4] = Integer.toString(newTrans);
                break;
            case "withdraw":
                transDetails[0] = Table.fixCellLength(" Withdrawal", 'l', BankDB.INI_REPORT_DESCRIPTION_LENGTH); //description
                transDetails[1] = Table.fixCellLength(nf.format(amount), 'r', BankDB.INI_REPORT_DEBIT_LENGTH); // debit
                transDetails[2] = Table.fixCellLength(" ", 'r', BankDB.INI_REPORT_CREDIT_LENGTH); // credit
                transDetails[3] = Table.fixCellLength(nf.format(bb.getCurrentBalance()) + " ", 'r', BankDB.INI_REPORT_BALANCE_LENGTH); // account balance
                transDetails[4] = Integer.toString(newTrans);
                break;
            case "withdrawalFee":
                transDetails[0] = Table.fixCellLength(" Withdrawal fee", 'l', BankDB.INI_REPORT_DESCRIPTION_LENGTH); //description
                transDetails[1] = Table.fixCellLength(nf.format(amount), 'r', BankDB.INI_REPORT_DEBIT_LENGTH); // debit
                transDetails[2] = Table.fixCellLength(" ", 'r', BankDB.INI_REPORT_CREDIT_LENGTH); // credit
                transDetails[3] = Table.fixCellLength(nf.format(bb.getCurrentBalance()) + " ", 'r', BankDB.INI_REPORT_BALANCE_LENGTH); // account balance
                transDetails[4] = Integer.toString(newTrans);
                break;
            case "withdrawalSetupFee":
                transDetails[0] = Table.fixCellLength(" Withdrawal setup fee", 'l', BankDB.INI_REPORT_DESCRIPTION_LENGTH); //description
                transDetails[1] = Table.fixCellLength(nf.format(amount), 'r', BankDB.INI_REPORT_DEBIT_LENGTH); // debit
                transDetails[2] = Table.fixCellLength(" ", 'r', BankDB.INI_REPORT_CREDIT_LENGTH); // credit
                transDetails[3] = Table.fixCellLength(nf.format(bb.getCurrentBalance()) + " ", 'r', BankDB.INI_REPORT_BALANCE_LENGTH); // account balance
                transDetails[4] = Integer.toString(newTrans);
                break;
            case "overDraftFee":
                transDetails[0] = Table.fixCellLength(" Over draft fee", 'l', BankDB.INI_REPORT_DESCRIPTION_LENGTH); //description
                transDetails[1] = Table.fixCellLength(nf.format(amount), 'r', BankDB.INI_REPORT_DEBIT_LENGTH); // debit
                transDetails[2] = Table.fixCellLength(" ", 'r', BankDB.INI_REPORT_CREDIT_LENGTH); // credit
                transDetails[3] = Table.fixCellLength(nf.format(bb.getCurrentBalance()) + " ", 'r', BankDB.INI_REPORT_BALANCE_LENGTH); // account balance
                transDetails[4] = Integer.toString(newTrans);
                break;
            case "withdrawFailed":
                transDetails[0] = Table.fixCellLength(" Withdrawal failed [$" + nf.format(amount) + "]", 'l', BankDB.reportTableLength); //descriptionh
                transDetails[1] = "";
                transDetails[2] = "";
                transDetails[3] = "";
                transDetails[4] = Integer.toString(newTrans);
                break;

        }



        bb.getTrans().add(transDetails);
    }
}
