package study03;

public class HeroTest {

	public static void main(String[] args) {
		HeroClass hero1 = new HeroClass("Ironman", "Hitech suit", 90, 80);
		HeroClass hero2 = new HeroClass("Torr", "Lightening", 520, 50);
		HeroClass hero3 = new HeroClass("Hulk", "Hammer", 100, 200);
		
//		System.out.println(hero1);
//		System.out.println(hero2);
//		System.out.println(hero3);
		
		System.out.println(hero2);		
		hero1.showHeroInfo();
		hero3.showHeroInfo();
	}
}
