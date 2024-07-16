class Account{
    double getBalance(){
        return 0;
    }

    static class SavingsAccount extends Account {
        double getSavings() {
            return 100;
        }
    }
    static class TermAccount extends Account {
        double getTermBalance() {
            return 1000;
        }
    }
    static class CurrentAccount extends Account {
        double getCurrentAccountBalance() {
            return 10000;
        }
    }

    static double getBalanceWithoutSwitchPattern(Account account) {
        double balance = 0;
        if(account instanceof SavingsAccount sa) {
            balance = sa.getSavings();
        }
        else if(account instanceof TermAccount ta) {
            balance = ta.getTermBalance();
        }
        else if(account instanceof CurrentAccount ca) {
            balance = ca.getCurrentAccountBalance();
        }
        return balance;
    }

    static double getBalanceWithSwitchPattern(Account account) {
        double result = 0;
        switch (account) {
            case null -> throw new RuntimeException("Oops, account is null");
            case SavingsAccount sa -> result = sa.getSavings();
            case TermAccount ta -> result = ta.getTermBalance();
            case CurrentAccount ca -> result = ca.getCurrentAccountBalance();
            default -> result = account.getBalance();
        };
        return result;
    }
}