package com.cejv416.bankaccount;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * this class includes all menus and statement output
 *
 * @author jfeng
 *
 */
public class InputOutput {

    private NumberFormat nf, nfCurrency, nfPercent;
    private Scanner sc;
    private SavingAccount sa;
    private CheckingAccount ca;

    /**
     * constructor
     *
     * @param sa saving account
     * @param ca checking account
     */
    public InputOutput(SavingAccount sa, CheckingAccount ca) {
        super();

        nf = NumberFormat.getInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);



        nfCurrency = NumberFormat.getCurrencyInstance();
        nfPercent = NumberFormat.getPercentInstance();
        nfPercent.setMaximumFractionDigits(3);

        sc = new Scanner(System.in);

        this.sa = sa;
        this.ca = ca;
    }

    /**
     * print the bank statement header
     */
    private void printReportHeader(BankBean bb) {
        // print the first line
        Table.printReportLine("=", BankDB.reportTableLength);

        // print the title
        System.out.print(Table.fixCellLength("Your " + bb.getAccountTypeValue() + " account monthly statement", 'c', BankDB.reportTableLength));
        System.out.print("\n");
    }

    /**
     * print the bank statement details
     */
    private void printReportDetails(BankBean bb) {
        Table.printReportLine("-", BankDB.reportTableLength);

        System.out.print(Table.fixCellLength(" Description", 'l', BankDB.INI_REPORT_DESCRIPTION_LENGTH));
        System.out.print(Table.fixCellLength("Debit", 'r', BankDB.INI_REPORT_DEBIT_LENGTH));
        System.out.print(Table.fixCellLength("Credit", 'r', BankDB.INI_REPORT_CREDIT_LENGTH));
        System.out.print(Table.fixCellLength("Balance ", 'r', BankDB.INI_REPORT_BALANCE_LENGTH));
        System.out.print("\n");

        Table.printReportLine("-", BankDB.reportTableLength);

        System.out.print(Table.fixCellLength(" Starting balance", 'l', BankDB.INI_REPORT_DESCRIPTION_LENGTH));
        System.out.print(Table.fixCellLength(nf.format(bb.getStartingBalance()) + " ", 'r', BankDB.reportTableLength - BankDB.INI_REPORT_DESCRIPTION_LENGTH));
        System.out.print("\n");

        for (int i = 0; i < bb.getTrans().size(); i++) {
            String[] t = bb.getTrans().get(i);

            if (t[4].equals("0")) {
                Table.printReportLine("-", BankDB.reportTableLength);
            }

            for (int j = 0; j < t.length - 1; j++) {
                System.out.print(t[j]);
            }
            System.out.print("\n");

        }

        Table.printReportLine("-", BankDB.reportTableLength);

        System.out.print(Table.fixCellLength(" Interest", 'l', BankDB.INI_REPORT_DESCRIPTION_LENGTH));
        System.out.print(Table.fixCellLength(nf.format(bb.getMonthlyInterest()), 'r', BankDB.INI_REPORT_DEBIT_LENGTH + BankDB.INI_REPORT_CREDIT_LENGTH));
        System.out.print(Table.fixCellLength(" ", 'l', BankDB.INI_REPORT_BALANCE_LENGTH));
        System.out.print("\n");

        Table.printReportLine("-", BankDB.reportTableLength);

        System.out.print(Table.fixCellLength(" Closing balance", 'l', BankDB.INI_REPORT_DESCRIPTION_LENGTH));
        System.out.print(Table.fixCellLength(nf.format(bb.getCurrentBalance()) + " ", 'r', BankDB.reportTableLength - BankDB.INI_REPORT_DESCRIPTION_LENGTH));
        System.out.print("\n");

        Table.printReportLine("-", BankDB.reportTableLength);
    }

    /**
     * print the bank statement footer
     */
    private void printReportFooter(BankBean bb) {
        System.out.println("    Total number of deposits: " + bb.getNumberOfDeposits());
        System.out.println("              Total deposits: " + nfCurrency.format(bb.getTotalDeposits()));
        System.out.println(" Total number of withdrawals: " + bb.getNumberOfWithdrawals());
        System.out.println("           Total withdrawals: " + nfCurrency.format(bb.getTotalWithdrawals()));
        System.out.println("        Annual Interest Rate: " + nfPercent.format(bb.getAnnualInterestRate()));
        System.out.println("                   Interests: " + nfCurrency.format(bb.getMonthlyInterest()));
        System.out.println("                 Service fee: " + nfCurrency.format(bb.getServiceCharge()));
        System.out.println("             Account balance: " + nfCurrency.format(bb.getCurrentBalance()));
        System.out.println("              Account status: " + (bb.isAccountStatus() ? "Active" : "Inactive"));
        Table.printReportLine("=", BankDB.reportTableLength);
    }

    /**
     * print statement
     *
     * @param bb BankBean
     */
    private void printReport(BankBean bb) {
        printReportHeader(bb);
        printReportDetails(bb);
        printReportFooter(bb);
    }

    /**
     * show welcome box in the beginning
     */
    private void showWelcomeBox() {
        System.out.println("*******************************************");
        System.out.println("*                                         *");
        System.out.println("*        Hello! Welcome to Bank App       *");
        System.out.println("*                                         *");
        System.out.println("*******************************************");

    }

    /**
     * show the main bank menu
     */
    private void showBankMenu() {
        System.out.println("*******************************************");
        System.out.println("*  Bank Menu                              *");
        System.out.println("*  A: Savings                             *");
        System.out.println("*  B: Checking                            *");
        System.out.println("*  C: Exit                                *");
        System.out.println("*******************************************");

        performBankMenu();
    }

    /**
     * perform the main bank menu
     */
    private void performBankMenu() {
        char menuItem;
        menuItem = requestMenuItem("abc");

        switch (menuItem) {
            case 'A':
                performSavingMenu();
                break;
            case 'B':
                performCheckingMenu();
                break;
            default:
                sc.close();
                break;
        }
    }

    /**
     * show the bank menu for saving account
     */
    private void showSavingMenu() {
        System.out.println("*******************************************");
        System.out.println("*  Saving Menu                            *");
        System.out.println("*  A: Deposit                             *");
        System.out.println("*  B: Withdrawal                          *");
        System.out.println("*  C: Report                              *");
        System.out.println("*  D: Return to Bank Menu                 *");
        System.out.println("*******************************************");

    }

    /**
     * perform the bank menu for saving account
     */
    private void performSavingMenu() {
        showSavingMenu();

        char menuItem;
        //using do while loop instead of calling the method itself to avoid memory leaking issue
        do {
            menuItem = requestMenuItem("abcd");

            switch (menuItem) {
                case 'A':
                    sa.makeDeposit(new BigDecimal(requestAmount()));
                    break;
                case 'B':
                    BigDecimal amount = new BigDecimal(requestAmount());
                    showWithdrawalResonse(sa.makeWithdraw(amount), amount);
                    break;
                case 'C':
                    BankBean saReport = sa.doMonthlyReport();

                    printReport(saReport);

                    requestContinue();
                    showSavingMenu();
                    break;
            }
        } while (menuItem != 'D');
        
        showBankMenu();
    }

    /**
     * show the bank menu for checking account
     */
    private void showCheckingMenu() {
        System.out.println("*******************************************");
        System.out.println("*  Checking Menu                          *");
        System.out.println("*  A: Deposit                             *");
        System.out.println("*  B: Withdrawal                          *");
        System.out.println("*  C: Report                              *");
        System.out.println("*  D: Return to Bank Menu                 *");
        System.out.println("*******************************************");

    }

    /**
     * perform the bank menu for checking account
     */
    private void performCheckingMenu() {
        
        showCheckingMenu();
        
        char menuItem;
        //using do while loop instead of calling the method itself to avoid memory leaking issue
        do {
            menuItem = requestMenuItem("abcd");

            switch (menuItem) {
                case 'A':
                    ca.makeDeposit(new BigDecimal(requestAmount()));
                    break;
                case 'B':
                    BigDecimal amount = new BigDecimal(requestAmount());
                    showWithdrawalResonse(ca.makeWithdraw(amount), amount);
                    break;
                case 'C':
                    BankBean caReport = ca.doMonthlyReport();

                    printReport(caReport);

                    requestContinue();
                    showCheckingMenu();
                    break;
            }
        } while (menuItem != 'D');
        
        showBankMenu();
    }

    /**
     * show welcome box and bank menu in the console
     */
    private void showMenu() {
        showWelcomeBox();
        showBankMenu();

    }

    /**
     * request user to input letter to select bank menu
     *
     * @param validator the string that concatenated by menu letters
     * @return return the selected menu
     */
    private char requestMenuItem(String validator) {

        char menuItem = '♥';
        String pattern = validator.toLowerCase() + validator.toUpperCase();
        // change validator to v,a,l,i,d,a,t,o,r
        String validatorStr = validator.toUpperCase().replaceAll("(.)", "$1,");
        validatorStr = validatorStr.substring(0, validatorStr.length() - 1);

        System.out.println("\n" + BankDB.INI_BANK_MENU_SELECT + validatorStr);

        do {
            if (sc.hasNext("[" + pattern + "]")) {
                menuItem = sc.next().toUpperCase().charAt(0);
            } else {
                menuItem = '♥';
                System.out.println("\n" + BankDB.INI_BANK_MENU_SELECT_AGAIN + validatorStr);
            }
            sc.nextLine();
        } while (menuItem == '♥');

        return menuItem;
    }

    /**
     * request user to input positive amount
     *
     * @return return the positive amount
     */
    private double requestAmount() {

        double amount;

        amount = 0;

        System.out.println(BankDB.INI_BANK_MENU_INPUT);

        do {
            if (sc.hasNextDouble()) {
                amount = sc.nextDouble();
                if (amount < 0.01) {
                    amount = 0;
                    System.out.println(BankDB.INI_BANK_MENU_INPUT_AGAIN);
                }
            } else {
                amount = 0;
                System.out.println(BankDB.INI_BANK_MENU_INPUT_AGAIN);
            }
            sc.nextLine();
        } while (amount <= 0);

        return amount;
    }

    /**
     * request user to press Enter to continue
     */
    private void requestContinue() {

        System.out.println(BankDB.INI_BANK_MENU_ENTER_CONTINUE);

        sc.nextLine();

    }

    /**
     * display message for withdrawal
     *
     * response code:<p> 0, withdrawal successful <p>1, withdrawal failed due to
     * Account is inactive <p>2, withdrawal failed due to insufficient fund,
     * over draft fee charged <p>3, withdrawal successful but account will be
     * inactive due to balance is below threshold <p>4, withdrawal failed due to
     * insufficient fund
     *
     * @param response response code
     * @param amount
     */
    private void showWithdrawalResonse(int response, BigDecimal amount) {
        switch (response) {
            case 0:
                System.out.println("\n" + BankDB.INI_BANK_WITHDRAWAL_SUCCESS + nfCurrency.format(amount));
                break;
            case 1:
                System.out.println("\n" + BankDB.INI_BANK_WITHDRAWAL_FAIL);
                break;
            case 2:
                System.out.println("\n" + BankDB.INI_BANK_WITHDRAWAL_OVERDRAFT);
                break;
            case 3:
                System.out.println("\n" + BankDB.INI_BANK_WITHDRAWAL_SUCCESS + nfCurrency.format(amount));
                System.out.println(BankDB.INI_BANK_WITHDRAWAL_BELOW_THRESHOLD);
                break;
            case 4:
                System.out.println("\n" + BankDB.INI_BANK_WITHDRAWAL_INSUFFICIENT);
        }
    }

    /**
     * start to perform the application to show bank menu
     */
    public void perform() {
        showMenu();
    }
}
