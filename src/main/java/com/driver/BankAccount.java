package com.driver;

import java.util.Random;

import static java.lang.Math.min;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


//    public String generateAccountNumber(int digits, int sum) throws Exception{
//        //Each digit of an account number can lie between 0 and 9 (both inclusive)
//        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
//        //If it is not possible, throw "Account Number can not be generated" exception
//       if(sum<0||sum>digits*9){
//           throw new AccountNumbercannotbegenerated("Account Number can not be generated");
//       }
//
//        String AccountNumber="";
//        int tem_Sum=sum;
//        Random rand=new Random();
//        for(int i=0;i<digits;i++){
//            int bound= min(tem_Sum,10);
//            int n= rand.nextInt(bound);
//            AccountNumber+=String.valueOf(n);
//            tem_Sum-=n;
//        }
////        if(tem_Sum>0)
////            throw new AccountNumbercannotbegenerated("Account Number can not be generated");
//
//        return AccountNumber;
//    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception

//        remaining number
        int rem = sum;
        String accNo = "";
        if(digits*9 < sum){
            throw new Exception("Account Number can not be generated");
        }
        else{
            while(digits > 0 && rem > 0){
                if(rem >= 9){
                    rem = rem - 9;
                    accNo = accNo + "9";
                }
                else{
                    accNo = accNo + Integer.toString(rem);
                    rem = 0;
                }
                digits--;
            }
            while(digits > 0){
                accNo = accNo + "0";
                digits--;
            }
            return accNo;
        }
//        return null;
    }

    public void deposit(double amount) {
        //add amount to balance
        this.balance+=amount;
        System.out.println("Amount added successfully Current Balance : "+balance);

    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(this.balance-amount<getMinBalance()){
            throw new Insufficient("Insufficient Balance");
        }
        balance-=amount;
        System.out.println("Amount Withdraw Successfully Current balance : "+balance);

    }

}