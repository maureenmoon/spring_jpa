package examClass01;

import java.util.ArrayList;
import java.util.List;

public class Subject {
	private String subjname;
	private List<Exam> exams;
	
	public Subject(String subjname) {
		this.subjname = subjname;
		this.exams = new ArrayList<>();
	}
	
	public String getSubjname() {
		return subjname;
	}

	public void addExam(int score, String date) {
		exams.add(new Exam(score,date));
	}
	public int getAvg() {
		int sum =0;
		for(Exam exam1:exams) {
			sum +=exam1.getScore();
		}
		return (int) Math.floor( (double)sum / exams.size());
	}

	public Exam getHighExam() {
		Exam highExam = exams.get(0);
		
		for(Exam exam1:exams) {
			if(exam1.getScore()> highExam.getScore()) {
				highExam = exam1;
			}
		}
		return highExam;
	}

	public void pringExam() {
		System.out.println("Subject : " + subjname);
		for(Exam exam1:exams) {
			System.out.println(" - " + exam1);
		}
		System.out.println("The avgerage score : "+getAvg());
	}
}