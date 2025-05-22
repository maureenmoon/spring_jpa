package pract_busfare;

public class Student {
	public String studentName;
	public int grade;
	public int money;
	
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	public void takeBus(Bus bus1) {
		bus1.take(1000);
		this.money -= 1000;
	}
	
	public void showInfo() {
		System.out.println(studentName + " has "+ money + " at hand");
	}
}
