import Controller.AdminController;
import Controller.TeacherController;
import Model.Admin;
import Model.BasicUser;
import Model.Department;
import Model.Rate;
import Model.Teacher;
import Model.TeacherLevel;
import Model.User;
import View.*;

public class MVCpattern {
	public static void main(String[] args) {
		User adminUser = new Admin(new BasicUser(), "Adminbek Adminzhanov", "a.adminzhanov", "Passswworrd", 9000);
		Admin admin = (Admin) adminUser;
		
		AdminController controller = new AdminController(admin, new AdminView());
		controller.run();
		
//		Department fit = new Department("FIT");
//		User pakitaUser = new Teacher(new BasicUser(), "Pakita San", "p.shamoi", "Password1", 10000, fit, TeacherLevel.PROFESSOR, new Rate(0, 0));
//		Teacher pakita = (Teacher) pakitaUser;
//		
//		TeacherController tc = new TeacherController(pakita, new TeacherView());
//		
//		tc.run();
		
		
	}
}
