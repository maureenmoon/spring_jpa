package electricProduct;

public class CustomerTest {

	public static void main(String[] args) {
		Customer cust = new Customer("Hong");
		cust.addProduct("Battery", 50000);
		cust.addProduct("Pad", 500000);
		cust.addProduct("Applepod", 120000);
		
		cust.printProduct();
		

		
	}

}
