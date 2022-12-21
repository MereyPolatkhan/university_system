package View;

import java.util.Vector;

import Model.Student;
import Model.Teacher;

public class StudentView {
	public static void showStudent(Vector<Student> students) {
		for (Student s: students) {
			System.out.println(s);
		}
	}

	public static void showStudent(Teacher teacher) {
		for (Student s: teacher.viewStudents()) {
			System.out.println(s);
		}
		
	}
}
