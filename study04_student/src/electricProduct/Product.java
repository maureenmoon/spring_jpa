package electricProduct;

public class Product {
	private String prodname;
	private int price;
	public Product(String prodname, int price) {
		this.prodname = prodname;
		this.price = price;
	}
	
	public String getProdname() {
		return prodname;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "- Product name =" + prodname + ", price = " + price;
	}

}
