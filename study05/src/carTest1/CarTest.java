package carTest1;

public class CarTest {

	public static void main(String[] args) {
		Car aiCar1 = new AiCar();
		System.out.println("-----"+ aiCar1 +"-------");
		aiCar1.run();
	
		Car mCar1 = new ManualCar();
		System.out.println("-----"+ mCar1 +"-------");
		mCar1.run();
		
	}

}
