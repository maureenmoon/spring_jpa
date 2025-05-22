package study04_coffee;
public class CoffeeShopClass {

	CoffeeClass[] menu;
	public CoffeeShopClass() { 
		menu = new CoffeeClass[] {
			new CoffeeClass("Americano", 4000),
			new CoffeeClass("Ice Americano", 4500),
			new CoffeeClass("Latte", 5000),
			new CoffeeClass("Isachoo", 6000)
		};
	}
	public void showMenu() {
		System.out.println("Menu list:");
		for(CoffeeClass coffee:menu) {
			System.out.println("coffee name is " + coffee.name + " , price is " + coffee.price);
		}
	}
	public CoffeeClass getCoffee(String coffeeName) {
		coffeeName = coffeeName.intern();
		for(CoffeeClass coffee:menu)
			if(coffee.name == coffeeName) {
				return coffee; //Americano
			}
		return null;
	}
}
