package study05_animal;

public abstract class Aimal {
	String name;
	int age;
	public Aimal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	//common method
	public void eat() {
		System.out.println(name + " eats food");
	}
	public void sleep() {
		System.out.println(name + " sleeps at night");
	}
	
	// abstract method
	public abstract void makeSound();

	@Override
	public String toString() {
		return "Aimal [name : " + name + ", age : " + age + "]";
	}
	
}
