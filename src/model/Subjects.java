package model;

import java.util.List;
import java.util.Map;

public class Subjects {
//	int standardId;
	//String academicYear; 
	int id;
	List<Integer> subjectids;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public String getAcademicYear() {
		return academicYear;
	}
	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}*/
	public List<Integer> getSubjectids() {
		return subjectids;
	}
	public void setSubjectid(List<Integer> subjectids) {
		this.subjectids = subjectids;
	}
	
}
