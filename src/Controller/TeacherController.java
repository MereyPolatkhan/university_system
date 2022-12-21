package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Config.Database;
import Model.BasicUser;
import Model.Course;
import Model.Department;
import Model.Manager;
import Model.Mark;
import Model.Rate;
import Model.Student;
import Model.Teacher;
import Model.TeacherLevel;
import Model.UserFactory;
import View.CourseView;
import View.ManagerView;
import View.StudentView;
import View.TeacherView;

public class TeacherController {
	

	public Teacher model;
	public TeacherView view;
	
	public TeacherController(Teacher  model, TeacherView view) {
		this.model = model;
		this.view = view;
	}
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static Teacher createTeacher() {

		Teacher teacher = (Teacher) UserFactory.createUser("Teacher");
		System.out.println("provide department name: ");
		try {
			String depName = br.readLine().trim();
			boolean depExists = false;
			for (Department d: Department.depatments) {
				if (d.name == depName) {
					depExists = true;
					teacher.department = d;
					break;
				}
			
			}
			if (!depExists) teacher.department = DepartmentController.createDepartment();
		} catch (IOException e) {
			System.out.println("incorrect something");
			e.printStackTrace();
		}
		
		System.out.println("Assign salary: ");
		try {
			teacher.setSalary(Double.parseDouble(br.readLine()));
		} catch (NumberFormatException | IOException e) {
			System.out.println("Provided incorrect type, please write appropriate type");
			e.printStackTrace();
		}
		System.out.println("Provide teacher level: 1.TUTOR, 2.SENIOR_LECTURER,  3.LECTURER, 4.ASSISTANT_PROFESSOR, 5.ASSOCIATE_PROFESSOR, 6.PROFESSOR");
		try {
			int lvl = Integer.parseInt(br.readLine());
			if (lvl == 1) teacher.teacherLevel = TeacherLevel.TUTOR;
			if (lvl == 2) teacher.teacherLevel = TeacherLevel.LECTURER;
			if (lvl == 3) teacher.teacherLevel = TeacherLevel.SENIOR_LECTURER;
			if (lvl == 4) teacher.teacherLevel = TeacherLevel.ASSISTANT_PROFESSOR;
			if (lvl == 5) teacher.teacherLevel = TeacherLevel.ASSOCIATE_PROFESSOR;
			if (lvl == 6) teacher.teacherLevel = TeacherLevel.PROFESSOR;	
	    	if (lvl == 4 || lvl == 4|| lvl == 5) 
	    		teacher.isResearcher = true;
	    	else
	    		teacher.isResearcher = false;
		} catch (NumberFormatException | IOException e) {
			System.out.println("Provided incorrect type, please write appropriate type");
			e.printStackTrace();
		}
		
		teacher.teacherRate = new Rate(0,0);
		Database.users.add(teacher);
		return teacher;
	}
	
	public void viewCourses() {
		CourseView.showCourses(model);
	}
	
	public void viewStudents() {
		StudentView.showStudent(model);
	}
	
	public void putMark() {
		Student student = new Student(new BasicUser());
		
		System.out.println("Please provide student name: e.g 'Merey Polatkhan' ");
		
		boolean studentExists = false;
		try {
			String name = br.readLine().trim();
			for (Student s: Database.getStudentsFromDB()) {
				if (s.firstLastName == name) {
					student = s;
					studentExists = true;
					break;
				}
			}
			if (studentExists) {
				System.out.println("Student exists, now pls provide course name: ");
			}
			else {
				System.out.println("student doesnt exist in system, try to ask to create this student");
				return;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Course course = new Course();
		
		try {
			String courseName = br.readLine().trim();
			boolean courseExists = false;
			for (Course c: Database.registrationCourses) {
				if (c.courseName == courseName) {
					courseExists = true;
					course = c;
					break;
				}
			}
			if (courseExists) {
				System.out.println("Course exists, now pls provide mark information");
			}
			else {
				System.out.println("Course doesnt exists in system, try to add from manager");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		Mark mark = new Mark();
		
		System.out.println("please provide 1st attestation mark: e.g 25.6, 0.0");
		try {
			double first = Double.parseDouble(br.readLine().trim());
			mark.setFirstAtt(first);
		} catch (NumberFormatException | IOException e) {
			System.out.println("Incorrect format");
			e.printStackTrace();
		}
		
		
		System.out.println("please provide 2nd attestation mark: e.g 25.6, 0.0");
		try {
			double second = Double.parseDouble(br.readLine().trim());
			if (mark.getFirstAtt() + second > 60) {
				mark.setFirstAtt(30);
				mark.setSecondAtt(30);
			}
			else mark.setSecondAtt(second);
		} catch (NumberFormatException | IOException e) {
			System.out.println("Incorrect format");
			e.printStackTrace();
		}
		
		System.out.println("please provide final attestation mark: e.g 35.6, 0.0");
		try {
			double finalatt = Double.parseDouble(br.readLine().trim());
			mark.setFinalAtt(finalatt);
			if (mark.getTotal().digitGrade > 100) {
				mark.setFinalAtt(40);
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Incorrect format");
			e.printStackTrace();
		}
		
		model.putMark(student, course, mark);
		System.out.println("Mark put succesfully");
		
	}
	
	
	
	
	

}
