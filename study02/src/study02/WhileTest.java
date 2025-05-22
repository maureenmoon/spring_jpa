package study02;

public class WhileTest {

//	add 1 to 10
	public static void main(String[] args) {

		int num = 1;
		int sum = 0;
		
		while (num <= 10) {
//			sum = sum + num;
//			num = num + 1;
//			
//		}
//		
			sum += num;
			num++;
		}
			
		System.out.println("Result of sum is \" " + sum + "\" ");
		System.out.println("num is " + num);
	
		int tsum = 0;
		int i = 1;
		
		while (true) {
			tsum += i;
			i++;
			
			if(i>10) {
				break;
			}
			
		}
		System.out.println(tsum);
		
		int jsum = 0;
		
		for (int j = 1; j <= 10; j++) {
			jsum +=j;
			System.out.println("j is " + j);		
		}
		System.out.println("jsum is " + jsum);
	
		}
		
}

	

