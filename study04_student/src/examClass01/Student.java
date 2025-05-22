package examClass01;

import java.util.ArrayList;
import java.util.List;

public class Student {
	private String name;
	private List<Subject> subjects;
	
	public Student(String name) {
		this.name = name;
		this.subjects = new ArrayList<>(); //ArrayList는 배열데이터를 임의로 선택적으로 가져올때 사용하는 용어
	}
	
	public void addSubject(String subjName) {
		subjects.add(new Subject(subjName));
	}
	
	public Subject getSubject(String subjName) {
		for(Subject subj1:subjects) {
			if(subj1.getSubjname() == subjName) {
				return subj1;
			}
			if(subj1.getSubjname().equals(subjName)) {
				return subj1;
			}
		}
		return null;
	}

	public void printAllSubject() {
		System.out.println("Student's name : " + name );
		for(Subject subj1:subjects) {
			subj1.pringExam();
			System.out.println();
		}
	}
}
