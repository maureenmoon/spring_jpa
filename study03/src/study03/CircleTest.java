package study03;

public class CircleTest {

	public static void main(String[] args) {
		Circle circle1 = new Circle(); //create object
		Circle circle2 = new Circle();
		circle1.radius = 100;
		circle2.radius = 10;
		

		double area = circle1.getArea();
		double area2 = circle2.getArea();
		System.out.println(area);
		System.out.println(area2);
	}

}
