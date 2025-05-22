package electricProduct;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String custname;
	private List<Product> products;
	
	public Customer(String custname) {
		this.custname = custname;
		this.products = new ArrayList<>();
	}
	
	public void addProduct(String prodName, int price) {
		products.add(new Product(prodName, price));
	}

	public void printProduct() {
		System.out.println(custname + " 's purchasing items : ");
		for(Product prod1:products) {
			System.out.println(prod1);
		}
		System.out.println(products.size() + "products purchased, and total amount is " + getAmount());
	}
	public int getAmount() {
		int amount = 0;
		for (Product prod1:products) {
			amount += prod1.getPrice();
		}
		System.out.println();
		return amount;
		}
	}
	
