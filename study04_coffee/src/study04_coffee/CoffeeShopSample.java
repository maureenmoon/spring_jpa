package study04_coffee;

import java.util.Scanner;

public class CoffeeShopSample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("coffee menu");
		System.out.println("1. Americano : 4000won");
		System.out.println("2. Ice Americano : 4500won");
		System.out.println("3. Latte : 5000won");
		System.out.println("4. the end");
		
//		client's balance
		int balance = 10000;
		boolean run = true;
		
		while(run) {
			System.out.println("Ps select a number of coffee");
			int select = sc.nextInt();
					
			int price = 0;
			String coffeeName = "";
			
			switch(select) {
				case 1:
					coffeeName = "Americano";
					price = 4000;
					break;
				case 2:
					coffeeName = "Ice Americano";
					price = 4500;
					break;
				case 3:
					coffeeName = "Latte";
					price = 5000;
					break;
				case 4:
					System.out.println("The order is closed.");
					run = false;
					continue;
				default:
					System.out.println("Pls choose the correct orer no.");
					continue;	
			}
			if(balance >= price) {
				balance -= price;
				System.out.println(coffeeName + "Order completed. Balance :" + balance);
			}else {
				System.out.println(coffeeName + "Balance shortage!!!. Balance :" + balance);
		}
//			System.out.println("Order list : " + coffeeName + "Price : " + price);
		}
	}
}


