package Model;

import java.util.Comparator;

public class RateComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Teacher t1 = (Teacher)o1;
		Teacher t2 = (Teacher)o2;
		
		if (t1.computeTeacherRate()< t2.computeTeacherRate()) {
			return -1;
		}
		else if (t1.computeTeacherRate() > t2.computeTeacherRate()) {
			return 1;
		}
		return 0;
	}

}
