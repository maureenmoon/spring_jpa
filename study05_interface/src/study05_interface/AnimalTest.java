package study05_interface;

public class AnimalTest {

	public static void main(String[] args) {
		Animal myDog = new Dog("Coco",3,"Maltis");
		Animal myCat = new Cat("Citty",1,"blue");
		
		
		myDog.showInfo();
		myDog.makeSound();
		myDog.eat();
		//Dog에 있는 wagTail을 쓰려면 downcasting해야함(형변환) important!!!
		Dog dog1 = (Dog)myDog;
		dog1.wagTail();
		
		Dog youDog = new Dog("Bily", 4, "Booldog");
		youDog.showInfo();
		youDog.eat();
		youDog.wagTail();
		System.out.println("-----------------");
		
		myCat.showInfo();
		myCat.makeSound();
		myCat.eat();
		Cat cat1 = (Cat)myCat;
		cat1.scratch();
		
		Cat youCat = new Cat("Cat2", 4, "white");
		youCat.showInfo();
		youCat.eat();
		youCat.scratch();
		System.out.println("-----------------");
		
		//arraylist applied: get, remove
		Animal[] animals = new Animal[3];
		animals[0] = new Dog("Hindoongi",3,"Jindogae");
		animals[1] = new Cat("Cat3",10,"black");
		
		for(Animal myAnimal:animals) {
			System.out.println(myAnimal);
			myAnimal.eat();
			myAnimal.makeSound();
			
			if(myAnimal instanceof Dog) {
				Dog dog3 = (Dog) myAnimal;
				dog3.wagTail();
			}
			if(myAnimal instanceof Cat) {
				Cat cat3 = (Cat) myAnimal;
				cat3.scratch();
			}
			System.out.println("***********");
		}
		
 		
	}

}
