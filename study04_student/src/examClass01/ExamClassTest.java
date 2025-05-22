package examClass01;

public class ExamClassTest {

	public static void main(String[] args) {
		Student stu1 = new Student("Hong");
		stu1.addSubject("Mathematics");
		stu1.addSubject("English");
		
		Subject math = stu1.getSubject("Mathematics");
		if(math != null) { // Mathematics 과목명인지 체크
			math.addExam(92, "2025-02-20");
			math.addExam(0, "2025-02-21");
			math.addExam(100, "2025-02-25");
		}
		
		Subject eng = stu1.getSubject("English");
		if(eng != null) {
			eng.addExam(50, "2025-01-19");
			eng.addExam(61, "2025-01-20");
			eng.addExam(77, "2025-01-21");
		}	
		
		Subject draw = stu1.getSubject("Drawing");
		if(draw != null) {
			draw.addExam(60, "2025-02-21");
		}
				
		stu1.printAllSubject();
	}
}
