package study03;

public class StudentClass {
	public int studNumber;
	public String stuName;
	public int grade;
	
	StudentClass(int snum, String sname, int g ) {
		studNumber = snum;
		stuName = sname;
		grade = g;
	}
		
	public String showStuInfo() {
		return "Student name is " + stuName + ",and ID is " + studNumber;
	}
	
	
}

