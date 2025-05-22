package study03;

public class DeskLamp {
	boolean isOn; // boolean having only two value, true or false
	
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
