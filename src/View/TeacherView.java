package View;

import java.util.Vector;

import Model.Teacher;

public class TeacherView {
	public static void showTeacher(Vector<Teacher> teachers) {
		for (Teacher t: teachers) {
			System.out.println(t);
		}
	}
}
