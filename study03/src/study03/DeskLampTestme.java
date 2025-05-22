package study03;

public class DeskLampTestme {

	public static void main(String[] args) {
		DeskLampMe myLamp1 = new DeskLampMe();
		DeskLampMe myLamp2 = new DeskLampMe();
		
		myLamp1.turnOff();
		System.out.println(myLamp1);
		
		myLamp2.turnOn();
		System.out.println(myLamp2);
		
		
	}

}
