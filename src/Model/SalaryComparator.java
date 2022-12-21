package Model;

import java.io.Serializable;
import java.util.Comparator;

public class SalaryComparator implements Comparator<Object> , Serializable{

	@Override
	public int compare(Object o1, Object o2) {
		Teacher t1 = (Teacher)o1;
		Teacher t2 = (Teacher)o2;
		
		if (t1.getSalary() < t2.getSalary()) {
			return -1;
		}
		else if (t1.getSalary() > t2.getSalary()) {
			return 1;
		}
		return 0;
	}

}
