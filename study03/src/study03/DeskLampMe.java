package study03;

public class DeskLampMe {
	
	boolean isOn;

	public void turnOn() {
		isOn = true;
	}
	
	public String toString() {
		return "current status is " + (isOn == true? "turn-on": "turn-off");
	}


	public void turnOff() {
		isOn = false;
	}
	 
}
