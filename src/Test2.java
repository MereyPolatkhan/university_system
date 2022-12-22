import Config.Database;
import Controller.LibrarianController;
import Controller.ManagerController;
import Controller.StudentController;
import Controller.TeacherController;
import Model.BasicUser;
import Model.Course;
import Model.Department;
import Model.Librarian;
import Model.Manager;
import Model.Rate;
import Model.Student;
import Model.Teacher;
import Model.TeacherLevel;
import Model.User;
import View.LibrarianView;
import View.ManagerView;
import View.StudentView;
import View.TeacherView;

public class Test2 {
	public static void main(String[] args) throws Exception  {
		Teacher pakita = null;
		
		for (Teacher t: Database.getTeachersFromDB()) {
			if (t.firstLastName.equals("Pakita San")) {
				pakita = t;
				break;
			}
		}
		
		TeacherController tc = new TeacherController(pakita, new TeacherView());
//		tc.run();
		
		Student st = null;
		
		for (Student s: Database.getStudentsFromDB()) {
			if (s.firstLastName.equals("Zhantore Svanov")) {
				st = s;
				break;
			}
		}
		
		StudentController stc = new StudentController(st, new StudentView());
		stc.run();
		
		
		Manager mana = null;
		for (Manager man: Database.getManagersFromDB()) {
			if (man.firstLastName.equals("Nazym Kaidarova")) {
				mana = man;
				break;
			}
		}
		
		ManagerController mc = new ManagerController(mana, new ManagerView());
//		mc.run();
		
		Librarian lib = null;
		for (Librarian l: Database.getLibrariansFromDB()) {
			if (l.firstLastName.equals("Libgulya Libova")) {
				lib = l;
				break;
			}
		}
		
		LibrarianController lccc = new LibrarianController(lib, new LibrarianView());
//		lccc.run();
	}
}
