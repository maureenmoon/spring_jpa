package pract_self;

public class self2_flow {

	public static void main(String[] args) {
//		age same or over 8, go to school. if not, cann't go to school
//		int age1 = 7;
//		int age2 = 8;
//		if (age1 >= 8) {
//			System.out.println("your age is " + age1 + " you can go to school as you are over 8 year old" );
//		}else 
//			System.out.println("your age is " + age1+ " you cannot go to school because you are less than 8 years old");
//		
//		char gender = 'S';
//		if (gender == 'F') {
//			System.out.println("you are female");
//		}else {
//			System.out.println("you are male");
//		}
//	}
//		less than 8, 1000
//		less than 14, 2000
//		less than 20, 2500
//		over, 3000
//
//		int age3 = 5;
//		int charge;
////		int charge = 1000;
//		
//		if (age3 < 8) {
//			System.out.println("you are preschooler");
//			charge = 1000;
//		}else if (age3 <14) {
//			System.out.println("junior-hi");
//			charge =  2000;
//		}else if (age3 <20) {
//			charge = 2500;
//			System.out.println("hi-school student ");
//		}else {
//			System.out.println("you are adult");
//		}
//		 	charge = 3000;
//		System.out.println("charge is "+charge);
//	}
//}
// medal per each rank: G,S,B, and default
//		int rank = 3;
//		char medal;
//		
//		switch(rank) {
//		case 1 : medal = 'G';
//			break;
//		case 2 : medal = 'S';
//			break;
//		case 3 : medal = 'B';
//			break;
//		default: 
//			medal = 'G';
//		}
//		System.out.println("rank "+rank+"'s medal is "+medal);
//		}
//	}
//		
// 12mth with days in each mth
//		int mth=11;
//		int days;
//		
//		switch(mth) {
//		case 1: case 3: case 5: case 7: case 8: case 10: case 12  : days = 31;
//			break;
//		case 2 : days = 28;
//			break;
//		case 4: case 6: case 9: case 11 : days = 30;
//			break;
//		default: days = 0;
//		System.out.println("invalid mth");
//		}
//		System.out.println(days+" days in "+mth);
//	}
//}
//sum to 10 from 1
//		int num=1;
//		int sum=0;
//	while(num <= 10) {
//		sum +=num;
//		num++;
//	}
//	System.out.println("sum of 1 to 10 is : " + sum);
//	}
//}	
//		int num = 1;
//		int sum;
//		for (sum =0;num <=10;num++) {
//			sum +=num;
//		}
//		System.out.println("Sum from 1 to 10 is "+sum);
//		}
//}
//		multiplication table
//		int i;
//		int j;
//		int sum;
//		for(i=2;i<=9;i++) {
//			System.out.println(i+" Dan list");
//			for (j=1;j<=9;j++) {
//			sum = (i * j);
//			System.out.println(i +" * " + j + " = " + sum);
//			}
//		}
//	}
//}
//		add odd numbers to 10
//		int sum=0;
//		int i;
//		
//		for(i=1;i<=10;i++) {
//			if(i%2==0) continue;
//				sum += i;
//		}
//		System.out.println("sum of odd numbers to 10 from 1 is "+sum);
//	}
//}
// times to add up from 0 to pass 100
		int i;
		int sum =0;
		for(i=0; ;i++) {
			sum += i;
			if(sum>=100) break;
		}
		System.out.println("sum : "+sum+" , add 0 upto "+ i);
		
		
	}
}
	
	
	
			
		
		
		
