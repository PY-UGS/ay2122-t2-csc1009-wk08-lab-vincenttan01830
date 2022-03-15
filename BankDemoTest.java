package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankDemoTest {
    public static void main(String[] args){
        CheckingAccount acc1 = new CheckingAccount(121, 5000);
        CheckingAccount acc2 = new CheckingAccount(212, 2500);
        Scanner input = new Scanner(System.in);

        try{
            System.out.println("Your balance after withdraw is: $" + acc1.getBalance());
            System.out.print("Enter the amount that you would like to deposit to the account " + acc1.getAccountNum() + ": ");
            double dAmount = input.nextDouble();
            acc1.deposit(dAmount);
            System.out.println("Your balance now is: $" + acc1.getBalance() + "\n");

            System.out.println("The balance of account " + acc2.getAccountNum() + " is " + acc2.getBalance());
            System.out.print("Enter the amount that you would like to withdraw from account " + acc2.getAccountNum() + ": ");
            double wAmount = input.nextDouble();
            if(acc2.withdraw(wAmount) >= 0){
                System.out.println("The balance after withdrawal is: $" + acc2.getBalance());
            }
        }
        catch(InputMismatchException e){
            System.out.println("Exception caught: Incorrect Data Type!");
        }
    }
}
