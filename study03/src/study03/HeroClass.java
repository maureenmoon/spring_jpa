package study03;

public class HeroClass {
	String playername;
	String powername;
	int attack;
	int defense;
	String rank;
	
	public HeroClass(String playername, String powername, int attack, int defense) {
		this.playername = playername;
		this.powername = powername;
		this.attack = attack;
		this.defense = defense;
		this.rank = calcRank();
	}

	private String calcRank() {
		int score = attack + defense;
		if(score >400) {
			return "S";
		}else if(score > 300) {
			return "A";
		}else if(score > 200) {
			return "B";
		}else { return "C";
		}
	}
	
	public void showHeroInfo() {
		System.out.println("히어로 : " + playername);
		System.out.println("능력 : " + powername);
		System.out.println("공격력 : " + attack);
		System.out.println("방어력 : " + defense);
		System.out.println("등급 : " + rank);
		}
	
	@Override
	public String toString() {
		return "HeroClass [playername= " + playername + ", powername= " + powername + ", attack= " + attack + ", defense= "
				+ defense + ", 🤳🤳nk= " + rank + "]";
	}
	
}
