package classRoom;

public class StudentTest {

	public static void main(String[] args) {
		Student stu = new Student("Steve");
		
		stu.addSubject("English", 50);
		stu.addSubject("Math", 80);
		stu.addSubject("Java", 90);
		
		stu.printSubjects();
		
	}
}
