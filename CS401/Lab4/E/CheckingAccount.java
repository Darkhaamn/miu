package E;

public class CheckingAccount extends Account {
    private double balance;
    private double monthlyFee;
    private String acctId;

    public CheckingAccount(String accId, double fee, double startBalance) {
        this.balance = startBalance;
        this.monthlyFee = fee;
        this.acctId = accId;
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
        return balance - monthlyFee;
    }
}
