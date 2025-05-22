package study03;

import java.util.ArrayList;
import java.util.List;

public class ArrayTestList {

	public static void main(String[] args) {
	
		ArrayList<String> name = new ArrayList<>();
		name.add("Apple");
		name.add("Peach");
		name.add("Banana");
		name.add("Mallon");
		name.add("Grape");
		
		System.out.println(name.size());
		System.out.println(name.get(1));
		
		for(int i=0;i<name.size();i++) {
			System.out.print(name.get(i));
		}
		
		for(String fruit:name) {
			System.out.println(fruit);
		}
		
	}

}
