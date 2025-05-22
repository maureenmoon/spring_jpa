package animalTest;

public class Dog extends Animal{
	String breed;
	
	public Dog(String name, int age, String breed) {
		super(name, age);
		this.breed = breed;
	}

	public void waveTail() {
		System.out.println(name+" is Dog, and waving a tail");
	}

	@Override
	public void makeSound() {
		System.out.println(name+" is barking");		
	}


	
	
}
