package study05_interface;

public interface Animal {
	int LEGS = 4;
//	public static 상수로 선언. 어디서든 사용가능
	int TAILS = 1;
	int EYES = 2;
	
	void makeSound();
	// abstract method: 선언부만 있음
	void eat();
	void showInfo();
	
}
