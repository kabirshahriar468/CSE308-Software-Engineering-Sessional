package account;

public class SavingsAcc extends Account
{
    private static double MIN_DEPOSIT = 1000;
    private static double MAX_LOAN = 10000;
    private static double MIN_INITIAL_DEPOSIT = 1000;

    private static double DEPOSIT_INTEREST_RATE = 10.0; // changeable
    private static double SERVICE_CHARGE = 500.0;

    public SavingsAcc() { setAccountType("Savings"); }

    public static double getDepositInterestRate() { return DEPOSIT_INTEREST_RATE; }
    public static void changeDepositInterestRate(double new_rate) { DEPOSIT_INTEREST_RATE = new_rate; }

    public static double getServiceCharge() { return SERVICE_CHARGE; }

    public boolean createAccount(double balance,String name)
    {
        if(balance >= MIN_INITIAL_DEPOSIT) {
            setTotalDeposit(balance);
            setAccountName(name);
            return true;
        }
        return false;
    }

    public boolean deposit(double amount)
    {
        if(amount >= MIN_DEPOSIT) {
            addBalance(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount)
    {
        if((amount +1000) < getTotalDeposit()) return false;
        else{
            removeBalance(amount);
            return true;
        }
    }

    public boolean requestLoan(double amount)
    {
        if(getLoan()+getPendingLoan()+amount <= MAX_LOAN) {
            setPendingLoan(getPendingLoan()+amount);
            return true; // loan request valid
        }
        return false;
    }
}
