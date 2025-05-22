package study04_mycoffee;

public class CoffeeShopClassme {
	
	CoffeeClassme[] menu;
	public CoffeeShopClassme() { 
		menu = new CoffeeClassme[] { 
			new CoffeeClassme("Americano", 4000),
			new CoffeeClassme("AA", 4500),
			new CoffeeClassme("Latte", 5000),
			new CoffeeClassme("Asachoo", 6500)
			};
		}
	
	public void showMenu() {
		System.out.println("Menu list :");
		for(CoffeeClassme coffee:menu) {
			System.out.println(coffee.name + " : " + coffee.price);
		}
	}
	 
	public CoffeeClassme getCoffee(String coffeeName) {
		coffeeName = coffeeName.intern();
		for(CoffeeClassme coffee:menu)
			if(coffee.name == coffeeName) {
				return coffee;
			}
		return null;
	}
}
