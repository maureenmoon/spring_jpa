package study04_coffee;

public class CustomerClass {
	String name;
	int balance;
	public CustomerClass(String name, int balance) {
		this.name = name;
		this.balance = balance;
	}
	public void buyCoffee(CoffeeShopClass shop,String coffeeName) {
		CoffeeClass coffee = shop.getCoffee(coffeeName);  // check coffee name
		if(coffee != null) {//data is right
			if(balance >= coffee.price) {
				balance -= coffee.price;
				System.out.println(coffee.name+" / " +coffee.price);
				System.out.println("The current balance is " + balance);
			}else {
				System.out.println("Balance shortage! The current balance is " + balance);
			}
		}else {
			System.out.println("Menu you ordered is not valid");
		}
	}
}
