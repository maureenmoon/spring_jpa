package study05_interface;

public class Cat implements Animal {
	private String name;
	private int age;
	private String color;
//	생성자 만들어줘야함
	public Cat(String name, int age, String breed) {
		this.name = name;
		this.age = age;
		this.color = color;
	}

	@Override
	public void makeSound() {
		System.out.println(name+" mewmew");
	}

	@Override
	public void eat() {
		System.out.println(name+ " eats fish");
	}

	@Override
	public void showInfo() {
		System.out.println("Cat's information - name : "+name+" , age : "+age);
		System.out.println("number of legs : "+LEGS+" , and tails : "+TAILS);
	}
	
	public void scratch() {
		System.out.println(name+" scratches");
	}
}
