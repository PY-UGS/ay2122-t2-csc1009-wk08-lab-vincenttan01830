package com.company;

public class CheckingAccount {
    private int accountNum;
    private double balance;

    public CheckingAccount(int accountNum, double balance){
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public void deposit(double amount){
        try{
            if(amount <= 0){
                throw new IllegalArgumentException("Cannot deposit 0 or negative amount!");
            }
            else{
                setBalance(getBalance() + amount);
            }
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }

    public double withdraw(double amount){
        double withdrawal = -1;
        try{
            if(amount <= 0){
                throw new IllegalArgumentException("Cannot withdraw 0 or negative amount!");
            }
            if(getBalance() < amount){
                double insuff = amount - getBalance();
                throw new InsufficientFundsException(insuff);
            }
            else{
                setBalance(getBalance() - amount);
                withdrawal = getBalance();
            }
        }
        catch(InsufficientFundsException e) {
            System.out.println("Sorry, but your account is short by: $" + e.getAmount());
            return withdrawal;
        }
        catch(IllegalArgumentException f){
            System.out.println(f.getMessage());
            return withdrawal;
        }
        return withdrawal;
    }
}
