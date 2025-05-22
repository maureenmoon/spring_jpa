package study04_bank;

public class BankTest1 {

	public static void main(String[] args) {
		BankAccount1 account = new BankAccount1("123-45-6789","maureen",1000000);
//		BankAccount1 account1 = new BankAccount1("123-45-6799","maureen2",40000);
		
		account.checkBalance();
		account.dePosit(50);
		account.withDraw(10);
		account.withDraw(30);
		account.withDraw(4000000);
		
		account.printTransactions(); //transaction info
	}
}
