package study02;

public class SwitchCase {

	public static void main(String[] args) {
		
		int mth = 10;
		int day;
		
		switch(mth) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				day = 31;
				break;
			case 2:
				day = 28;
				break;
			case 4: case 6: case 9: case 11:
				day = 30;
				break;
			default:
				day = 0;
				System.out.println("invalid mth");
		}

		System.out.println(mth + "mth has " + day + "days.");
	}
}
		
//		if(mth==1) {
//			day=31
//		}
//		
//		if(mth == 10) {
//			day = 31;
//			
//		}else {
//			day = 0;
//		}
//			
//			
//		}else {
//			day = 0;
//			System.out.println("invalid month");
//		}
//		
//		output인 경우, 초기값 불필요
//		switch(month) {
//			case 10:
//				day = 31;
//				break;
//			default:
//				day = 0;
//				System.out.println("invalid month");
//				
//		
//		}
//
//		System.out.println(day);

