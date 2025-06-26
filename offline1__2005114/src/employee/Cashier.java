package employee;

import account.FixedDepositAcc;
import account.SavingsAcc;
import account.StudentAcc;

public class Cashier extends Employee
{
    public Cashier(String name)
    {
        setEmployeeName(name);
        setEmployeeType("Cashier");
    }

    public boolean canApproveLoan(){return false;}
    public boolean changeInterestRate(String ac_type,double new_rate)
    {

        return false;
    }

    public boolean canSeeInternalFund() { return false; }
}

