package C;

import java.time.LocalDate;

public class Driver {
    void main() {
        Employee e1 = new Hourly("E001", 25.0, 40);
        Employee e2 = new Salaried("E002", 5000.0);

        Commissioned e3 = new Commissioned("E003", 0.10, 1500.0);
        e3.addOrder(new Order("O1001", LocalDate.of(2026, 4, 3), 2000));
        e3.addOrder(new Order("O1002", LocalDate.of(2026, 4, 15), 3000));
        e3.addOrder(new Order("O1003", LocalDate.of(2026, 3, 20), 4000)); // not include

        Employee[] employees = {e1, e2, e3};

        int month = 4;
        int year = 2026;

        for (Employee emp : employees) {
            emp.print();
            Paycheck paycheck = emp.calcCompensation(month, year);
            paycheck.print();
            System.out.println("---------------------------");
        }
    }
}
