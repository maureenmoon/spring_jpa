package study05_interface;

public class Dog implements Animal {
	private String name;
	private int age;
	private String breed;
//	생성자 만들어줘야함
	public Dog(String name, int age, String breed) {
		this.name = name;
		this.age = age;
		this.breed = breed;
	}

	@Override
	public void makeSound() {
		System.out.println(name+" barks");
	}

	@Override
	public void eat() {
		System.out.println(name+ " eats anything");
	}

	@Override
	public void showInfo() {
		System.out.println("Dog's information - name : "+name+" , age : "+age);
		System.out.println("number of legs : "+LEGS+" , and tails : "+TAILS);
	}
	
	public void wagTail() {
		System.out.println(name+" wags its tail");
	}
}
