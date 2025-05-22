package study03;

public class ArrayTest1 {
	public static void main(String[] args) {
		int[] num = new int[5];
		num[0] = 10;
		num[1] = 100;
		System.out.println(num[0]);
		
		String[] name = new String[] {"Seoul", "Busan","Dague"};
			System.out.println(name[2]);
		
		int[] num1 = {10,20,25};
		for(int i=0;i<num1.length;i++) {
			System.out.println(num1[i]);
		}
		for(int j:num1) {			//for ~ each
			System.out.println(j);
		}
	
	String[] name2 = {"AA", "BB", "CC"};
	for(int k=0;k<name2.length;k++){
		System.out.print(name2[k]);
		}
	
	String[] name1 = new String[] {"aa","bb","cc","dd"};
	for(String m:name1) {
		System.out.print(m);
	}
	}	
}