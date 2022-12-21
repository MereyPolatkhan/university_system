package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import Config.Database;
import Model.Department;
import Model.Speciality;
import Model.Student;
import Model.StudentLevel;
import Model.UserFactory;

public class StudentController {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static Student createStudent() {
		
		Student student = (Student) UserFactory.createUser("Student");
		System.out.println("Please provide student level: 1.BACHELOR, 2.MASTER, 3.PhD");
		try {
			int stdLvl = Integer.parseInt(br.readLine());
			if (stdLvl == 1) student.level = StudentLevel.BACHELOR;
			if (stdLvl == 2) student.level = StudentLevel.MASTER;
			if (stdLvl == 3) {student.level = StudentLevel.PhD; student.isResearcher = true;}
		} catch (NumberFormatException | IOException e) {
			System.out.println("incorrect format");
			e.printStackTrace();
		}
		
		System.out.println("Please provide student year: ");
		try {
			int year = Integer.parseInt(br.readLine());
			student.year = year;
		} catch (NumberFormatException | IOException e) {
			System.out.println("incorrect format");
			e.printStackTrace();
		}
		
		System.out.println("provide department name: ");
		try {
			String depName = br.readLine().trim();
			boolean depExists = false;
			for (Department d: Department.depatments) {
				if (d.name == depName) {
					depExists = true;
					student.department = d;
					break;
				}
			
			}
			if (!depExists) student.department = DepartmentController.createDepartment();
		} catch (IOException e) {
			System.out.println("incorrect something");
			e.printStackTrace();
		}
		
		
		System.out.println("Please prodive speciality name: ");			
		try {
			String specName =  (br.readLine()).trim();
			student.speciality = new Speciality(specName);
		} catch (IOException e) {
			System.out.println("Provided incorrect data");
			e.printStackTrace();
		}
		Database.users.add(student);
		
		return student;
		
		
	}
}
