package classRoom.practice;

public class Subject {
	private String subname;
	private int score;
	
	public Subject(String subname, int score) {
		this.subname = subname;
		this.score = score;
	}
	public String getSubname() {
		return subname;
	}
	public int getScore() {
		return score;
	}
	@Override
	public String toString() {
		return "Subject [subname=" + subname + ", score=" + score + "]";
	}
}
