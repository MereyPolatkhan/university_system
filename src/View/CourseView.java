package View;

import Model.*;

public class CourseView {
	public static void showCourses(Teacher teacher) {
		for (Course c: teacher.courses) {
			System.out.println(c);
		}
	}
}
