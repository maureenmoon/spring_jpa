package study03;

public class BoxTest {

	public static void main(String[] args) {
		BoxClass box1 = new BoxClass();
		box1.width = 100;
		box1.length = 10;
		box1.height = 5;
		
		double volume = box1.getVolume();
		System.out.println(" The size of box: Width " + box1.width + ", Length " + box1.length + ", Height " + box1.height);		
		System.out.println(" The volume of box is " +volume);
		
		
	}

}
