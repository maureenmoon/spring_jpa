package examClass;

public class StudentTest {

	public static void main(String[] args) {
		Student stu = new Student("Mark");
		stu.addSubject("Java", 50);
		stu.addSubject("CSS", 80);
		stu.addSubject("Flex", 60);
		
		stu.printSubject();
//		System.out.println("The highest score of subject : " + stu.getHiScore());
//		System.out.println(stu.getHigh());
		
	}
}
