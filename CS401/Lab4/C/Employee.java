package C;

public abstract class Employee {
    private String empId;

    public Employee(String empId) {
        this.empId = empId;
    }

    public void print() {
        System.out.println("Employee ID: " + empId);
    }

    public Paycheck calcCompensation(int month, int year) {
        double grossPay = calcGrossPay(month, year);

        double fica = grossPay * 0.23;
        double state = grossPay * 0.05;
        double local = grossPay * 0.01;
        double medicare = grossPay * 0.03;
        double socialSecurity = grossPay * 0.075;

        return new Paycheck(grossPay, fica, state, local, medicare, socialSecurity);
    }


    public abstract double calcGrossPay(int month, int year);
}
