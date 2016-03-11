package model;

import java.util.List;
import java.util.Map;

public class Division {
	String divId;
	int Id;

//List<Subjects> subjects;
List<Student> students;
List<Subject> subjects;
//Map<Integer,Division> divPerClass;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}


public List<Subject> getSubjects() {
	return subjects;
}
public void setSubjects(List<Subject> subjects) {
	this.subjects = subjects;
}
public String getDivId() {
	return divId;
}
public void setDivId(String divId) {
	this.divId = divId;
}
public List<Student> getStudents() {
	return students;
}
public void setStudents(List<Student> students) {
	this.students = students;
}


}
