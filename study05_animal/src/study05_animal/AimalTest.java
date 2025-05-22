package study05_animal;

public class AimalTest {

	public static void main(String[] args) {
		Aimal[] aimals = new Aimal[2];
		aimals[0] = new Dog("Mimi",3,"Maltiz");
		aimals[1] = new Cat("Citty",2, "Black");
		
		for(Aimal ani2:aimals) {
			System.out.println(ani2);
			ani2.eat();
			ani2.sleep();
			ani2.makeSound();
			System.out.println("-----------");
		
		}
			Dog myDog = (Dog)aimals[0];
			myDog.tail();
			Cat myCat = (Cat)aimals[1];
			myCat.scratch();
		
	}
	}


