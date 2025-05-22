package study04_bank;

import java.util.ArrayList;
import java.util.List;

public class BankAccount1 {
	String accountNum;
	String owner;
	double balance;
	List<String> transactions;
	
	public BankAccount1(String accountNum, String owner, double balance) {
		this.accountNum = accountNum;
		this.owner = owner;
		this.balance = balance;
		this.transactions = new ArrayList<>();
		transactions.add("Welcome. The opening balance: " + balance + "won");
		}
	
	public void printTransactions() {
		System.out.println(owner + " 's deposit/withdraw list");
		for(String t:transactions) {
			System.out.println(t);
		}
	}
	
	public void checkBalance() {
		System.out.println("Mr/Ms." +owner+". The balance is " + balance);
		System.out.println();
	}
	
	
	public void dePosit(double amount) {
		if(amount>0) {
			balance += amount;
			transactions.add("deposit amount : " + amount + ", and the current balance : " + balance);
			System.out.println("deposit amount is " + amount + ", the current balance is " + balance);
		}else {
			System.out.println("deposit amount should be more than zero");
			System.out.println("-------------------------------------------------------------------");
		}
	}

	public void withDraw(double amount) {
		if(amount > 0 && balance >=amount ) {
			balance -= amount;
			transactions.add("withdraw amount : " + amount + ", and the current balance : " + balance);
			System.out.println("Withdraw amount is " + amount + ", the current balance is " + balance);
		}else if(amount > balance) {
			System.out.println("Balance shortage. The current balance is " + balance);
		}else {
			System.out.println("Withdraw amount should be more than zero");
			System.out.println("-------------------------------------------------------------------");
		}
	}
}
