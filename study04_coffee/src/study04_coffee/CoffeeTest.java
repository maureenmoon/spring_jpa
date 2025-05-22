package study04_coffee;

import java.util.Scanner;

public class CoffeeTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		CoffeeShopClass shop = new CoffeeShopClass(); //instance 'shop' created
		CustomerClass customer = new CustomerClass("maureen", 10000);//instance 'customer' created
		
//		customer.buyCoffee(shop,"Americano"); // fr customer class
//		customer.buyCoffee(shop,"Latte"); // fr customer class
//		customer.buyCoffee(shop,"Lat"); // fr customer class		
		
		shop.showMenu(); // from coffeeShop class
		customer.buyCoffee(shop,"Latte"); // fr customer class
		customer.buyCoffee(shop,"Lat"); // fr customer class
		while(true) {
			System.out.println("input order coffee name");
			String coffeeName = sc.nextLine();
			if(coffeeName.equalsIgnoreCase("exit")) {
				System.out.println("order is completed");
				break;
			}
			System.out.println(coffeeName + " ordered");
			customer.buyCoffee(shop, coffeeName);
		}
	}
}
