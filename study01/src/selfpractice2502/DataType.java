package selfpractice2502;

public class DataType {

	public static void main(String[] args) {
		int iNum=10;
		double dNum=2.0;
		int sNum1 = (int)(iNum + dNum);
		int sNum2 = (int)(iNum - dNum);
		int sNum3 = (int)(iNum * dNum);
		int sNum4 = (int)(iNum / dNum);
		
		System.out.println(sNum1);
		System.out.println(sNum2);
		System.out.println(sNum3);
		System.out.println(sNum4);
		
		char ch1 = 'A';
		System.out.println(ch1);

		System.out.println((int)ch1);

		char ch2 = '한';
		char ch3 = '\uD55C';
		System.out.println(ch2);

		System.out.println(ch3);

		char ch4 = '글';
		char ch5 = '\uAE00';
		System.out.println(ch4);

		System.out.println(ch5);
		
	}

}
