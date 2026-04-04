package C;

public class Hourly extends Employee {
    private double hourlyWage;
    private double hoursPerWeek;

    public Hourly(String empId, double hourlyWage, double hoursPerWeek) {
        super(empId);
        this.hourlyWage = hourlyWage;
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Type: Hourly");
        System.out.println("Hourly Wage: " + hourlyWage);
        System.out.println("Hours/Week: " + hoursPerWeek);
    }

    @Override
    public double calcGrossPay(int month, int year) {
        return hourlyWage * hoursPerWeek * 4;
    }
}
