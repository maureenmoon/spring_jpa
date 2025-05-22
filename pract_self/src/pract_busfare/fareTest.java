package pract_busfare;

public class fareTest {

	public static void main(String[] args) {
		Student student1 = new Student("James", 5000);
		Student student2 = new Student("Cindy", 9000);
		
		Bus bus100 = new Bus(100);
		student1.takeBus(bus100);
		student1.showInfo();
		bus100.showInfo();
		
		
		
	}

}
