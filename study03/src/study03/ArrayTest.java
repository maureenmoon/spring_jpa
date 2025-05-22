package study03;

public class ArrayTest {

	public static void main(String[] args) {

		int[] number = new int[3];
		
		number[0] = 10;
		number[1] = 11;
		number[2] = 21;	
		number[0] = 82;
//		number[3] = 30; index 3 is out of bounds for length 3

		for(int i=0;i<number.length;i++) {
			System.out.println( i + "number is " + number[i]);		
			
		}
		
		String[] city = new String[] {"Seoul", "Busan", "Gwangju"};
		for (int i=0;i<city.length;i++) {
			System.out.println(city[i]);
		}
		
	}

}
