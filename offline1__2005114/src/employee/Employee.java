
package employee;

import account.Account;

abstract public class Employee
{
    private String EmployeeName;
    private String EmployeeType;
    public String getEmployeeName() {
        return EmployeeName;
    }

    public String getEmployeeType() {
        return EmployeeType;
    }

    public void setEmployeeType(String employeeType) {
        EmployeeType = employeeType;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }
    // @Override
//    public String toString() {
//        return "Employee{" +
//                "name='" + EmployeeName + '\'' +
//                '}';
//    }

    public double lookup(Account ac) { return ac.getTotalDeposit(); }
    abstract public boolean canApproveLoan();
    abstract public boolean changeInterestRate(String ac_type,double new_rate);
    abstract public boolean canSeeInternalFund();
}