package study02;

import java.util.Scanner;

public class IfElseTest {

	public static void main(String[] args) {
		
		int age;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input age");
		
		age = sc.nextInt();
						
//		System.out.println(age);
		
		if(age>=8) {
			System.out.println("Allow to attend a school");
		}else {
			System.out.println("Not permitted to attend a school");
		}
	}

}
