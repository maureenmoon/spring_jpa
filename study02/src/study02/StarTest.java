package study02;

public class StarTest { 
	
	public static void main(String[] args) {
		
		int n = 5;	//total print line
		
		//left arrange
		for(int i = 1; i <= n; i++) {	// repeat "n" times
			for(int j = 1; j <= i; j++) {	// repeat "i" times
				System.out.print("*");
			}
			System.out.println();	//line break
		}
	
		//right arrange
		for(int i = 1; i <= n; i++) {	
			for(int j = n; j > i; j--) {	// number of "empty space" to print
				System.out.print(" ");
			}
			for(int k = 1; k<=i;k++) {	
				System.out.print("*");
			}
			System.out.println();	//line break
		}
		
		//piramid
		for(int i = 1; i <= n; i++) {	
			for(int j = n; j > i; j--) {	// number of "empty space" to print
				System.out.print(" ");
			}
			for(int k = 1; k<=(2 * i - 1); k++) {	// 2*i-1	
				System.out.print("*");
			}
			System.out.println();	
		}
		
	}	
}		

//		for(int i=1;i<6;i++) {
//			for(int k=1;k<=i;k++) {
//				System.out.println(" ");
//			}
//			for(int j=1;<;j++) {
//				 System.out.print("*");
//				 }	
//		}
