package E;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    void main() {
        Employee e1 = new Employee("Alice");
        e1.addAccount(new CheckingAccount("C100", 25.0, 1000.0));
        e1.addAccount(new SavingAccount("S100", 0.05, 2000.0));

        Employee e2 = new Employee("Bob");
        e2.addAccount(new CheckingAccount("C200", 10.0, 500.0));
        e2.addAccount(new SavingAccount("S200", 0.10, 1500.0));
        e2.addAccount(new SavingAccount("S201", 0.04, 1000.0));

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);

        double total = Admin.computeUpdatedBalanceSum(employees);
        System.out.println("Total updated balance sum = " + total);
    }
}
