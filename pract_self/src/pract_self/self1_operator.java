package pract_self;

public class self1_operator {

	public static void main(String[] args) {
		int mathScore =90;
		int engScore=100;
		int totScore = mathScore +engScore;
		double avg = totScore/2;
		
		System.out.println("sum : " +totScore);
		
		System.out.println("avg :"+avg);
		
		int gameScore = 150;
		int lastScore1=++gameScore;
		System.out.println("pre-operator score :"+lastScore1+", gameScore"+gameScore);
		
		int bonusScore = 150;
		int lastScore2=bonusScore++;
		System.out.println("post-operator score :"+lastScore2+", bonusScore"+bonusScore);
		
		int num=10;
		boolean isEven;
		isEven = (num % 2) == 0 ? true : false;
		System.out.println(isEven);
		int result = ~num;
		System.out.println(result);
		
		int n;
		double m;
		n = - 5 + 3;
		m = - 5 + 3 * 10;
		System.out.println("n : " + n+" , m : "+m);
		
		
				

		
	}
	

}
