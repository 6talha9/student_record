package model;

import java.util.List;
import java.util.Map;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class AcademicYear {
	int startYear, endYear,id;
//List<ClassStd> classStd;
Map<Integer,ClassStd> clasEveryYear;
/*public List<ClassStd> getClassStd() {
	return classStd;
}
public void setClassStd(List<ClassStd> classStd) {
	this.classStd = classStd;
}*/

public int getStartYear() {
	return startYear;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public void setStartYear(int startYear) {
	this.startYear = startYear;
}
public int getEndYear() {
	return endYear;
}
public void setEndYear(int endYear) {
	this.endYear = endYear;
}
public Map<Integer, ClassStd> getClasEveryYear() {
	return clasEveryYear;
}
public void setClasEveryYear(Map<Integer, ClassStd> clasEveryYear) {
	this.clasEveryYear = clasEveryYear;
}


}
