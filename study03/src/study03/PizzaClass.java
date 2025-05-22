package study03;

public class PizzaClass {
	int size;
	String ptype;
	
	public PizzaClass(int s, String t) {
		size = s;
		ptype = t;
	
	}
	
	public String toString() {
		return System.out.println(size + ptype);
	}
	
}
