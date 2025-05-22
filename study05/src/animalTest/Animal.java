package animalTest;

public class Animal {
	protected String name;
	private int age;

	public Animal(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public void showInfo() {
		System.out.println("Name : "+name+", age : "+age);
	}
//	@Override
//	public String toString() {
//		return "Animal [name=" + name + ", age=" + age + "]";
//	}
	public void makeSound() {
		System.out.println(name+"is barking");
	}
}	
	
	


