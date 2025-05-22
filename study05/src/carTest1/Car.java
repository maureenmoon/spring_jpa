package carTest1;

public abstract class Car {
	abstract void drive();//구현부{}없어서 처음에는 에러표시남
	abstract void stopDriving();
	
	void startCar() {
		System.out.println("turn-on");
	}
	void turnoff() {
		System.out.println("turn-off");
	}
	
	final void run() {
		startCar();
		drive();
		stopDriving();
		turnoff();
	}
}
