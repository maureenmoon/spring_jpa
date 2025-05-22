package study04_mycoffee;

public class CustomerClassme {
	String name;
	int balance;
	public CustomerClassme(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}
	
	public void buyCoffeeme(CoffeeShopClassme shop, String coffeeName) {
		CoffeeClassme coffee = shop.getCoffee(coffeeName);
		if(coffee!=null) {
			if(balance <= coffee.price) {
				balance -=coffee.price;
				System.out.println("Your order: " + coffee.name + " / " + coffee.price);
				System.out.println("The current balance is " + balance);
			}else {
			System.out.println("Banace shortage! The current balance is " + balance);
			}
		}else {
			System.out.println("Menu is invalid");
				
			}
	}
}
