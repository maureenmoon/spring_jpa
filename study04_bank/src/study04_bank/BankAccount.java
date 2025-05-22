package study04_bank;

public class BankAccount {
	int accountNum;
	String ownerName;
	int balance;
	
	void doposit(int count) {
		balance +=count;
	}
	void withDraw(int count) {
		balance -= count;
	}
	
	@Override
	public String toString() {
		return "BankAccount [ownerName=" + ownerName + ", balance=" + balance + "]";
	}


		
	}

