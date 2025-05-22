package study02;

import java.util.Scanner;

public class DanScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		System.out.println("it is gugudan progran");
		System.out.println("add dan number");
		
		while (true) {
			int dan = sc.nextInt();		
//			if(dan>=10) {
//				System.out.println("invalid");
//				break;
//			}
			
			System.out.println("you input " + dan);
			for(int i=1;i<10;i++) {
				System.out.println(dan + " x " + i + " = " + dan*i);			
						
		}
	}
}
}
