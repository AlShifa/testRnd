package com.syne.collection;

public class Student {
 Integer studId ;
 String studName;
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((studId == null) ? 0 : studId.hashCode());
	result = prime * result + ((studName == null) ? 0 : studName.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Student other = (Student) obj;
	if (studId == null) {
		if (other.studId != null)
			return false;
	} else if (!studId.equals(other.studId))
		return false;
	if (studName == null) {
		if (other.studName != null)
			return false;
	} else if (!studName.equals(other.studName))
		return false;
	return true;
}
	
}
