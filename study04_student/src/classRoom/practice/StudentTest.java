package classRoom.practice;

public class StudentTest {

	public static void main(String[] args) {
		Student stu = new Student("Mark");
		stu.addSubject("Java", 90);
		stu.addSubject("CSS", 55);
		stu.addSubject("Flex", 70);
		
		stu.printSubject();
	}
}
