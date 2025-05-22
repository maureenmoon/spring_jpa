package animalTest;

public class AnimalTest {

	public static void main(String[] args) {
		Dog dog1 = new Dog("Coco",5,"Maltis");
		dog1.showInfo();
		dog1.makeSound();
		dog1.waveTail();
		System.out.println();
	

		Cat cat1 = new Cat("Nabi",3,"Blue");
		cat1.showInfo();
		cat1.makeSound();
		cat1.scratch();
	}
}
