package intranet;

import java.util.Comparator;

public class RateComparator implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		Teacher t1 = (Teacher)o1;
		Teacher t2 = (Teacher)o2;
		
		if (t1.teacherRate < t2.teacherRate) {
			return -1;
		}
		else if (t1.teacherRate > t2.teacherRate) {
			return 1;
		}
		return 0;
	}

}
