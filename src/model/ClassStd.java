package model;

import java.util.List;
import java.util.Map;

public class ClassStd {
int ClassStdId,Id;
//List<Division> div;
Map<Integer,Division> divPerClass;

public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public int getClassStdId() {
	return ClassStdId;
}
public void setClassStdId(int classStdId) {
	ClassStdId = classStdId;
}

public Map<Integer, Division> getDivPerClass() {
	return divPerClass;
}
public void setDivPerClass(Map<Integer, Division> divPerClass) {
	this.divPerClass = divPerClass;
}




}
