package study04_mycoffee;

import java.util.Scanner;

public class CoffeeTestme {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		CoffeeShopClassme shop = new CoffeeShopClassme();
		CustomerClassme customer = new CustomerClassme("maureen",10000);
		
		shop.showMenu();
		customer.buyCoffeeme(shop, "Latte");
		
		while(true) {
			System.out.println("input coffee name");
			String coffeeName = sc.nextLine();
			if(coffeeName.equalsIgnoreCase(coffeeName)) {
				System.out.println("Your order is complete");
				break;
			}
			System.out.println(coffeeName + "is orderd");
			customer.buyCoffeeme(shop, coffeeName);
		}
		
	}
}
