package study05;

public abstract class Animal {
	int age;
	public void eat() {
		System.out.println("eating");
	}
	@Override
	public String toString() {
		return "Animal [age=" + age + "]";
	}

	
}
