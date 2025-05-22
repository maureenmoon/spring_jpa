package classRoom;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<Subject> subjects;
	
	public Student(String name) {
		this.name = name;
		this.subjects = new ArrayList<>();
	}
	
	public void addSubject(String subjectName, int score) {
		subjects.add(new Subject(subjectName, score));
	}
	
	public void printSubjects() {
		System.out.println("Subject list of " + name);
		for(Subject subject1:subjects) {
			System.out.println("- " + subject1);
		}
		System.out.println("number of subjects = " + subjects.size() + ". Avg score = " + getAvg());
	}
	
	public int getAvg() {
		int totScore = 0;
		for(Subject subj1:subjects )
			totScore += subj1.getScore();
		
		System.out.println("total scores = " + totScore);
		return (int) Math.floor((double) totScore / subjects.size());
	}
}
