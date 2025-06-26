package employee;

import account.FixedDepositAcc;
import account.SavingsAcc;
import account.StudentAcc;

public class ManagingDirector extends Employee
{
    public ManagingDirector(String name)
    {
        setEmployeeName(name);
        setEmployeeType("ManagingDirector");
    }

    public boolean canApproveLoan(){return true;}
    public boolean changeInterestRate(String ac_type,double new_rate)
    {
        if(ac_type.equals("Savings")) {
            SavingsAcc.changeDepositInterestRate(new_rate);
        }
        else if(ac_type.equals("Student")) {
            StudentAcc.changeDepositInterestRate(new_rate);
        }
        else if(ac_type.equals("Fixed_Deposit")) {
            FixedDepositAcc.changeDepositInterestRate(new_rate);
        }
        return true;
    }

    public boolean canSeeInternalFund() { return true; }
}
