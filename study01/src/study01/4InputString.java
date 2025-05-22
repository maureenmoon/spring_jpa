package study01;

import java.util.Scanner;

public class InputString {

	public static void main(String[] args) {
	
		String a;
		int b;
		
		Scanner sc = new Scanner(System.in);
	
		
		System.out.print("input name");		
		a = sc.nextLine();
		
		System.out.print("input age");
		b = sc.nextInt();
		
		
		System.out.println("Mr/Ms " + a + ". Hello! You are "+ b + " years old");

	}
}



