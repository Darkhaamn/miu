package C;

public class Salaried extends Employee {
    private double salary;

    public Salaried(String empId, double salary) {
        super(empId);
        this.salary = salary;
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return salary;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Type: Salaried");
        System.out.println("Salary: " + salary);
    }
}
