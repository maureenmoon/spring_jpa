package study04_student;

public class Student {
	private String name;
	int age;
	
	public Student(String name,int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age>0) {
		this.age = age;
		}else {
			System.out.println("Age should be larger than zero");
			this.age = 1;
		}

	
	}
}
