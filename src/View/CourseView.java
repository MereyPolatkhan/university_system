package View;

import Model.*;

public class CourseView {
	public static void showCourses(Teacher teacher) {
		System.out.println(teacher.courses.size());
		for (Course c: teacher.courses) {
			System.out.println(c);
		}
	}
}
