package E;

import java.util.List;

public class Admin {

    static public double computeUpdatedBalanceSum(List<Employee> list) {
        double sum = 0.0;
        for (Employee emp : list) {
            sum += emp.computeUpdateBalanceSum();
        }
        return sum;
    }
}
