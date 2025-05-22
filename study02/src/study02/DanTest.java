package study02;

import java.util.Scanner;

public class DanTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print(" input Dan numer");
		
		int dan= sc.nextInt();
		System.out.println(" you add " + dan);
		for(int i=2;i<10;i++) {
			System.out.println(dan + " x " + i + " = " + dan*i);
		}
	}

}
