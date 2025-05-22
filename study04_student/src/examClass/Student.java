package examClass;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String stuname;
	private List<Subject> subjects;

	public Student(String stuname) {
		this.stuname = stuname;
		this.subjects = new ArrayList<>();
	}

	public void addSubject(String subjectName, int score) {
		subjects.add(new Subject(subjectName, score));
	}

	public void printSubject() {
		System.out.println(stuname);
		for(Subject subj1:subjects) {
			System.out.println(subj1);
		}
		System.out.println("Total " + subjects.size() + ", the average is : "+ getAvg());
		Subject topScore1 = getHiScore();
		System.out.println("The highest subject : "+topScore1.getSubname()+" , score : "+topScore1.getScore());
	}
	
	public int getAvg() {
		int totScore = 0;
		for (Subject subj1:subjects) {
			totScore += subj1.getScore();
		}
		System.out.println(totScore);
		return (int) Math.floor((double) totScore/subjects.size());
	}
	
	public Subject getHiScore() {
		Subject highs1 = subjects.get(0);
		for( Subject subj1: subjects) {
			if(subj1.getScore() > highs1.getScore()) {
				highs1 = subj1;
			}
		}
		return highs1;
	}

	public Subject getHigh() {
		Subject high1 = subjects.get(0); //List<Subject> subjects
										//high1.getScore() 50
		for(Subject subj2: subjects) {
			if(subj2.getScore() > high1.getScore()) {
				high1 = subj2;
			}
		}
		return high1;
	}
}




