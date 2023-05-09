import java.util.Vector;

import Config.Database;
import Controller.AdminController;
import Controller.ManagerController;
import Controller.StudentController;
import Controller.TeacherController;
import Model.Admin;
import Model.Attestation;
import Model.BasicUser;
import Model.Department;
import Model.Manager;
import Model.ManagerTypes;
import Model.Speciality;
import Model.Student;
import Model.Teacher;
import Model.Transcript;
import Model.User;
import Model.UserDecorator;
import View.AdminView;
import View.ManagerView;
import View.StudentView;
import View.TeacherView;

public class TestPakita {
	public static void main(String[] args) { 
//		User adminUser = new Admin(new BasicUser(), "Admin A", "admin", "Paswworrd1", 1000);
//		Admin admin = (Admin) adminUser;
//		
//		AdminController ac = new AdminController(admin, new AdminView());
//		ac.run();
		
		
		
		
		Department dep = new Department("FIT");
		User managerUser = new Manager(new BasicUser(), "Kaidarova N", "kaid", "PassssWpp", 2000, ManagerTypes.FACULTY, dep);
		Manager manager = (Manager)managerUser;
		
		ManagerController mc = new ManagerController(manager, new ManagerView());
		mc.run();
		
		
		
		
//		Teacher teacherHiroharu = null;
//		for (Teacher t: Database.getTeachersFromDB()) {
//			if (t.firstLastName.equals("HiroHaru")) {
//				teacherHiroharu = t;
//				break;
//			}
//		}
//		TeacherController tc = new TeacherController(teacherHiroharu, new TeacherView());
//		tc.run();
//		
//		
//		
		
//		Student atsushi = null;
//		for (Student s: Database.getStudentsFromDB()) {
//			if (s.firstLastName.equals("Atsushi")) {
//				atsushi = s;
//				break;
//			}
//		}
//		atsushi.speciality = new Speciality("IS");
//		atsushi.setTranscript(new Transcript(new Vector<Attestation>()));
//		StudentController scAts = new StudentController(atsushi, new StudentView());
//		scAts.run();
//		
//		
//		
//		Student pakita = null;
//		for (Student s: Database.getStudentsFromDB()) {
//			if (s.firstLastName.equals("Pakita")) {
//				pakita = s;
//				break;
//			}
//		}
//		StudentController scPak= new StudentController(pakita, new StudentView());
//		scPak.run();
		
		
		
		
	}
}
