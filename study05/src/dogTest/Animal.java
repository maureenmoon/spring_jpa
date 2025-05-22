package dogTest;

public class Animal {
	private String name;
	private int age;
	public Animal(String name, int age) {
		this.setName(name);
		this.age = age;
	}
	
	
	public void showInfo() {	
		System.out.println("name : "+getName()+", age : "+age);
	}

//	@Override <== same as showInfo()
//	public String toString() {
//		return "Animal [name=" + name + "]";
//	}

	public void makeSound() {
		System.out.println(getName() + "bark");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

