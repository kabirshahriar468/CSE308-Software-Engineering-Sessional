package employee;

import account.FixedDepositAcc;
import account.SavingsAcc;
import account.StudentAcc;

public class Officer extends Employee
{
    public Officer(String name)
    {
        setEmployeeName(name);
        setEmployeeType("Officer");
    }

    public boolean canApproveLoan(){return true;}
    public boolean changeInterestRate(String ac_type,double new_rate)
    {

        return false;
    }

    public boolean canSeeInternalFund() { return false; }
}

