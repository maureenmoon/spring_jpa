package study05_animal;

public class Dog extends Aimal {
	String breed;

	public Dog(String name, int age, String breed) {
		super(name, age);
		this.breed = breed;
	}

	@Override
	public void makeSound() {
		System.out.println(name + " barks");
	}

	public void tail() {
		System.out.println(name + " shakes a tail");
	}

	@Override
	public String toString() {
		return "Dog breed = " + breed + ", and "+ super.toString();
	}


}
