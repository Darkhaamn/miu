package E;

import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private List<Account> accounts;

    public Employee(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account acct) {
        if (acct != null) {
            accounts.add(acct);
        }
    }

    public double computeUpdateBalanceSum() {
        double sum = 0.0;
        for (Account acct : accounts) {
            sum += acct.computeUpdateBalance();
        }
        return sum;
    }
}
