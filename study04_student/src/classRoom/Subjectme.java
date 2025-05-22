package classRoom;

public class Subjectme {
	private String subname; 
	private int score;
	public Subjectme(String subname, int score) {
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
		return "Subjectme [subname= " + subname + ", score= " + score + "]";
	}
	

}
