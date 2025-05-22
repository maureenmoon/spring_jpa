package study05_animal;

public class Cat extends Aimal {
	String Color;

	public Cat(String name, int age, String breed) {
		super(name, age);
		this.Color = breed;
	}

	@Override
	public void makeSound() {
		System.out.println(name + " mewmew");
	}

	public void scratch() {
		System.out.println(name + " scratches");
	}

	@Override
	public String toString() {
		return "Cat color = " + Color +" , and " + super.toString();
	}


}
