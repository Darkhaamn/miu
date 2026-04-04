package E;

public class SavingAccount extends Account {
    private double balance;
    private double intersetRate;
    private String acctId;

    public SavingAccount(String accId, double interestRate, double startBalance) {
        this.balance = startBalance;
        this.acctId = accId;
        this.intersetRate = interestRate;
    }

    @Override
    String getAccountID() {
        return acctId;
    }

    @Override
    double getBalance() {
        return balance;
    }

    @Override
    double computeUpdateBalance() {
        return balance + (intersetRate * balance);
    }
}
