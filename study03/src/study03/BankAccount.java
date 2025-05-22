package study03;

public class BankAccount {
//bank balance//
	double balance;
	
	public BankAccount(double initBankAccount) {	//initialization//
		this.balance = initBankAccount;
		
	}
	

	private void deposit(double amount) {
		if(amount > 0) {
			
		balance += amount;
		System.out.println(balance + " deposited");
		}else {
		System.out.println("amount should be more than zero");
		}
	}
	
	public static void main(String[] args) {
		BankAccount account = new BankAccount(0);	
		
		account.deposit(1000);
		account.deposit(0);
		account.deposit(265);
		
	}

}
