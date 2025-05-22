package practice_polymor;

import java.util.ArrayList;
import java.util.List;

public class AnumalTest {

	public static void main(String[] args) {
		Animal hAnimal	= new Human(); // type conversion
		Animal tAnimal	= new Tiger();

		List<Animal> aList = new ArrayList<>();
		aList.add(hAnimal);
		aList.add(tAnimal);
		
		for(Animal ani:aList) {
			ani.move();
		}
	}

}
