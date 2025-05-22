package animalTest;

public class Cat extends Animal{
	String color;
	
		public Cat(String name, int age, String color) {
		super(name, age);
		this.color = color;
	}

		public void scratch() {
			System.out.println(name+" is Cat, and scratching");
		}

		@Override
		public void makeSound() {
			System.out.println(name+" is Meaw Meaw");
		}
		
		
	}

