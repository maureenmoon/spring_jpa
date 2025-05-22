package classRoom.practice;

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
		System.out.println(subjects.size() + ", "+ getAvg());
	}
	
	public int getAvg() {
		int totScore = 0;
		for (Subject subj1:subjects) {
			totScore += subj1.getScore();
		}
		System.out.println(totScore);
		return (int) Math.floor((double) totScore/subjects.size());
	}
}
