package bank;

import account.Account;
import account.FixedDepositAcc;
import account.SavingsAcc;
import account.StudentAcc;
import employee.Cashier;
import employee.Employee;
import employee.ManagingDirector;
import employee.Officer;

import java.util.ArrayList;

public class Bank
{
    private double fund;
    ArrayList<Account> accounts;
    ArrayList<Employee> employees;

    final double INIT_FUND = 1000000;

    public Bank()
    {
        fund = INIT_FUND;
        accounts = new ArrayList<Account>();
        employees = new ArrayList<Employee>();

        ManagingDirector MD = new ManagingDirector("MD");
        Officer O1 = new Officer("S1");
        Officer O2 = new Officer("S2");
        Cashier C1 = new Cashier("C1");
        Cashier C2 = new Cashier("C2");
        Cashier C3 = new Cashier("C3");
        Cashier C4 = new Cashier("C4");
        Cashier C5 = new Cashier("C5");

        employees.add(MD);
        employees.add(O1);
        employees.add(O2);
        employees.add(C1);
        employees.add(C2);
        employees.add(C3);
        employees.add(C4);
        employees.add(C5);
    }

    public double getFund() { return fund; }
    public void setFund(double fund) { this.fund = fund; }
    public void addNewAccount(Account ac){
        accounts.add(ac);
    }
    public boolean pkEnsured(String name)
    {
        for(Account ac:accounts)
        {
            if(ac.getAccountName().equals(name))
                return false;
        }
        return true;
    }

    public boolean isEmployee(String name)
    {
        for(Employee e:employees)
        {
            if(name.equals(e.getEmployeeName()))
            {
                return true;
            }
        }
        return false;
    }
    public boolean isAccountHolder(String name)
    {
        for(Account ac:accounts)
        {
            if(name.equals(ac.getAccountName()))
            {
                return true;
            }
        }
        return false;
    }

    public Object getPeople(String name)
    {
        for(Employee e:employees)
        {
            if(name.equals(e.getEmployeeName()))
            {
                return (Employee)e;
            }
        }

        for(Account ac:accounts)
        {
            if(name.equals(ac.getAccountName()))
            {
                return (Account)ac;
            }
        }

        return null;
    }

    public boolean isLoanPending()
    {
        for(Account ac:accounts)
        {
            if(ac.getPendingLoan()>0)
            {
                return true;
            }
        }
        return false;
    }

    public void approveLoan()
    {
        for(Account ac:accounts)
        {
            double p = ac.getPendingLoan();
            if( p > 0 && fund-p >0)
            {
                ac.addLoan(p);
                ac.addBalance(p);
                ac.setPendingLoan(0.0);
                System.out.println("Loan approved for "+ac.getAccountName());

                fund -= p; // update bank fund
            }
        }
    }

    public void increaseYear()
    {
        for(Account ac:accounts)
        {
            ac.setYear(ac.getYear()+1);

            double cur_loan = ac.getLoan() , cur_balance = ac.getTotalDeposit() , service_charge = 0.0;
            double deposit_interest = 0.0;
            double loan_interest = cur_loan * Account.getLoanInterestRate() * 0.01;

            // handle account
            if(ac.getAccountType().equals("Savings")){ deposit_interest = cur_balance * SavingsAcc.getDepositInterestRate() * 0.01; service_charge = SavingsAcc.getServiceCharge(); }
            if(ac.getAccountType().equals("Student")){ deposit_interest = cur_balance * StudentAcc.getDepositInterestRate() * 0.01; service_charge = StudentAcc.getServiceCharge(); }
            if(ac.getAccountType().equals("Fixed_Deposit")){ deposit_interest = cur_balance * FixedDepositAcc.getDepositInterestRate() * 0.01; service_charge = FixedDepositAcc.getServiceCharge(); }

            ac.addBalance(deposit_interest);
            ac.removeBalance(loan_interest + service_charge);

            // handle bank
            fund -= deposit_interest;
            fund += loan_interest;
            fund += service_charge;
        }
    }
}