package carTest1;

public class AiCar extends Car{

	@Override
	void drive() {
		System.out.println("AI drives itself");
		System.out.println("AI change a direction itself");
	}

	@Override
	void stopDriving() {
		System.out.println("AI stop itself");		
	}

}
