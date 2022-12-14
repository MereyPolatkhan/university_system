package intranet;

import java.util.Comparator;

public class GPAComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Student s1 = (Student) o1;
		Student s2 = (Student) o2;
		
		if (s1.getGeneralGPA() < s2.getGeneralGPA()) {
			return -1;	
		}
		else if (s1.getGeneralGPA() > s2.getGeneralGPA()) {
			return 1;
		}
		return 0;
	}

}
