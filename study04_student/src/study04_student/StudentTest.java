package study04_student;

public class StudentTest {

	public static void main(String[] args) {
		Student maureen = new Student("Steve",20);
//		maureen.name = "Steve";
//		maureen.age = 10;
		
		maureen.setAge(-30);
		
		System.out.println("Name : " + maureen.getName() + " , age : " + maureen.getAge());

	}

}
