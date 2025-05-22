package carTest1;

public class ManualCar extends Car{

	@Override
	void drive() {
		System.out.println("human drives a car");
		System.out.println("human operates a handle");
	}

	@Override
	void stopDriving() {
		System.out.println("human push a break to stop a car");		
	}

}
