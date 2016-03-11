package model;

import java.util.List;
import java.util.Map;

public class Student {
	int studentsRollNo,id;
	String name;
	 
	//List<MarksSheet> MarksSheet;
	//int[] marks;
	Map<Integer,Subject> markInSubject;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentsRollNo() {
		return studentsRollNo;
	}
	public void setStudentsRollNo(int studentsRollNo) {
		this.studentsRollNo = studentsRollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Integer, Subject> getMarkInSubject() {
		return markInSubject;
	}
	public void setMarkInSubject(Map<Integer, Subject> markInSubject) {
		this.markInSubject = markInSubject;
	}
	
}
