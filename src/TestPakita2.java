import Config.Database;
import Controller.ManagerController;
import Controller.TeacherController;
import Model.Admin;
import Model.BasicUser;
import Model.Department;
import Model.Manager;
import Model.ManagerTypes;
import Model.Rate;
import Model.Speciality;
import Model.Student;
import Model.StudentLevel;
import Model.Teacher;
import Model.TeacherLevel;
import Model.User;
import View.ManagerView;
import View.TeacherView;

public class TestPakita2 {
	public static void main(String[] args) {
//		Department fit = new Department("FIT");
//		User atsushiUser= new Student(new BasicUser(), "Atsushi", "at", "Passssword", StudentLevel.MASTER, 1, fit, new Speciality("Intellectual Systems"));
//		Student atsushi = (Student) atsushiUser;
//		
//		User pakitaUser = new Student(new BasicUser(), "Pakita", "pak", "Passssword", StudentLevel.MASTER, 2, fit, new Speciality("Intellectual Systems"));
//		Student pakita = (Student) pakitaUser;
//		
//		
//		User hiroharuUser = new Teacher(new BasicUser(), "HiroHaru", "hh", "Password1", 10000, fit, TeacherLevel.PROFESSOR, new Rate(0, 0));
//		Teacher hiroharu = (Teacher) hiroharuUser;
//		
//		Admin.addUser(atsushi);
//		Admin.addUser(pakita);
//		Admin.addUser(hiroharu);
//		
//		
//		Department dep = new Department("FIT");
//		User managerUser = new Manager(new BasicUser(), "Kaidarova N", "kaid", "PassssWpp", 2000, ManagerTypes.FACULTY, dep);
//		Manager manager = (Manager)managerUser;
//		
//		ManagerController mc = new ManagerController(manager, new ManagerView());
//		mc.run();
//		
		
		Teacher teacherHiroharu = null;
		for (Teacher t: Database.getTeachersFromDB()) {
			if (t.firstLastName.equals("HiroHaru")) {
				teacherHiroharu = t;
				break;
			}
		}
		TeacherController tc = new TeacherController(teacherHiroharu, new TeacherView());
		tc.run();
	}
}
