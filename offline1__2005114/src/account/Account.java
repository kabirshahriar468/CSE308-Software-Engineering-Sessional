package account;

abstract public class Account
{
    private String accountName;
    private double totalDeposit;

    private double loan;
    private double pendingLoan;
    private int year;
    private String accountType;


    Account()
    {
        loan = 0;
        pendingLoan = 0;
        year = 0;
    }

    static double LOAN_INTEREST_RATE = 10.0;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getTotalDeposit() {
        return totalDeposit;
    }

    public void setTotalDeposit(double totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

//    public double getBalance() { return balance; }
//    public void setBalance(double balance) { this.balance = balance; }
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }

    public double getLoan() { return loan; }
    public void setLoan(double loan) { this.loan = loan; }

    public double getPendingLoan() { return pendingLoan; }
    public void setPendingLoan(double pendingLoan) { this.pendingLoan = pendingLoan; }

//    public int getAc_age() { return ac_age; }
//    public void setAc_age(int ac_age) { this.ac_age = ac_age; }

    public static double getLoanInterestRate() { return LOAN_INTEREST_RATE; }
    public static void setLoanInterestRate(double loanInterestRate) { LOAN_INTEREST_RATE = loanInterestRate; }

//    @Override
//    public String toString() {
////        return "Account{" +
////                "ac_type='" + ac_type + '\'' +
////                ", balance=" + totalDeposit +
////                ", name='" + accountName + '\'' +
////                ", loan=" + loan +
////                ", pendingLoan=" + pendingLoan +
////                ", LOAN_INTEREST_RATE=" + LOAN_INTEREST_RATE +
////                '}';
//        return "Account{" +
//                "  balance=" + totalDeposit +
//                ", name='" + accountName + '\'' +
//                ", loan=" + loan +
//                ", pendingLoan=" + pendingLoan +
//                ", LOAN_INTEREST_RATE=" + LOAN_INTEREST_RATE +
//                '}';
//    }

    public void addBalance(double amount) { this.totalDeposit += amount; }
    public void removeBalance(double amount) { this.totalDeposit -= amount; }

    public void addLoan(double amount) { this.loan += amount; }
//    public void removeLoan(double amount) { this.loan += amount; }

    abstract public boolean createAccount(double balance,String name);
    abstract public boolean deposit(double amount);
    abstract public boolean withdraw(double amount);
    abstract public boolean requestLoan(double amount);
}
