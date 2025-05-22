package dogTest;

public class dogTest {

	public static void main(String[] args) {
		Dog dog1 = new Dog("Hindoongi", 3);
		dog1.showInfo();
		dog1.makeSound();

		Dog dog2 = new Dog("Coco", 5);
		System.out.println(dog2);
		dog2.makeSound();
		
		Dog dog3 = new Dog("Bori", 2);
		System.out.println(dog3);
		dog3.makeSound();
		

	}

}
