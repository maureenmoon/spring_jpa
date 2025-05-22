package classRoom;

import java.util.ArrayList;
import java.util.List;

public class Studentme {
	private String stuname;
	private List<Subjectme> subjects;
	
	public Studentme(String stuname) {
		this.stuname = stuname;
		this.subjects = new ArrayList<>();
	}
	 
	public void addSubject(String subjectName, int score) {
		subjects.add(new Subjectme(subjectName, score));
	}
	
	public void printSubject() {
		System.out.println("Subject list of " + stuname);
		for(Subjectme subject1:subjects) {
			System.out.println("- " + subject1);
		}
		System.out.println(subjects.size() + ", " + getAvg());
	}
	
	public int getAvg() {
		int totScore = 0;
		for( Subjectme subj2:subjects) {
			totScore += subj2.getScore();
		}
		System.out.println();
		return (int) Math.floor((double) totScore/subjects.size());
	}
}
