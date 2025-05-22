package classRoom;

public class StudentTestme {

	public static void main(String[] args) {
		Studentme stu = new Studentme("Mark");
		
		stu.addSubject("Eng", 90);
		stu.addSubject("CSS", 80);
		stu.addSubject("STS", 50);
		
		stu.printSubject();
	}

}
