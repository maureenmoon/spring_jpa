package study04_bank;

public class BankTest {

	public static void main(String[] args) {
		BankAccount name = new BankAccount();
		name.ownerName = "maureen";
		name.doposit(1000);
		System.out.println(name);
		
		name.withDraw(600);
		System.out.println(name);
		
	}

}
