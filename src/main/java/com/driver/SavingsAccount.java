package com.driver;

public class SavingsAccount extends BankAccount{
    double rate;

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    double maxWithdrawalLimit;

    public double getRate() {
        return rate;
    }

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit, double rate) {
        // minimum balance is 0 by default
        super(name,balance,0);
        this.rate=rate;

    }
    public void withdraw(double amount) throws Exception {
        // Might throw the following errors:
        // 1. "Maximum Withdraw Limit Exceed" : If the amount exceeds maximum withdrawal limit
        if(maxWithdrawalLimit<amount)
            throw new Exception("Maximum Withdraw Limit Exceed");
        // 2. "Insufficient Balance" : If the amount exceeds balance
        if(getBalance()<amount)
            throw new Exception("Insufficient Balance");
        double current_bal=getBalance()-amount;
        setBalance(current_bal);
        System.out.println("Your current balance is : "+current_bal);

    }

    public double getSimpleInterest(int years){
        // Return the final amount considering that bank gives simple interest on current amount
        double principle_amount=getBalance();
        double SimpleInterest=(principle_amount*rate*years)/100;
        return SimpleInterest;
    }

    public double getCompoundInterest(int times, int years){
        // Return the final amount considering that bank gives compound interest on current amount given times per year
        double CompoundInterest = getBalance() * Math.pow((1 + rate / (100*times)), times * years);
          return CompoundInterest;
    }

}
