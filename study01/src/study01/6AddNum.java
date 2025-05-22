package study01;

import java.util.Scanner;

public class AddNum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a,b,sum;
		
		System.out.print("initial numer");		
		a = sc.nextInt();
		
		System.out.print("input 2nd number");
		b = sc.nextInt();
		
//		String b = sc.nextLine();
		
		sum = a + b;
		
		System.out.println(a + " add "+ b + " = " + sum);

	}

}
