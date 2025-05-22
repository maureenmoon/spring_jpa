package animalTest2;

public class Human extends Animal {
	int myAge;
	
	@Override
	public void move() {
		System.out.println("human moves with two legs ");
	}
	public void readBooks() {
		System.out.println("human reads a book");
	}

}
