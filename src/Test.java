import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import Config.Database;
import Model.*;

import java.time.*;

public class Test {
	public static void main(String[] args) {

		Course ads = new Course("ADS", 1, 4);
		Set<Lesson> lessonsADS = new HashSet<Lesson>();
		Lesson lectureADS = new Lesson(LessonType.LECTURE, 120, 464, new TimeSlot(WeekDay.SAT, LocalTime.of(15, 00, 00), LocalTime.of(17, 00, 00)));
		Lesson practiceADS = new Lesson(LessonType.PRACTICE, 60, 270, new TimeSlot(WeekDay.FRI, LocalTime.of(13, 00, 00), LocalTime.of(14, 00, 00)));
		lessonsADS.add(lectureADS);
		lessonsADS.add(practiceADS);
		ads.lessons = lessonsADS;
		
		Course oop = new Course("OOP", 2, 4);
		Set<Lesson> lessonsOOP = new HashSet<Lesson>();
		Lesson lectureOOP = new Lesson(LessonType.LECTURE, 120, 446, new TimeSlot(WeekDay.MON, LocalTime.of(12, 00, 00), LocalTime.of(14, 00, 00)));
		Lesson practiceOOP = new Lesson(LessonType.PRACTICE, 60, 269, new TimeSlot(WeekDay.MON, LocalTime.of(18, 00, 00), LocalTime.of(19, 00, 00)));
		lessonsOOP.add(lectureOOP);
		lessonsOOP.add(practiceOOP);
		oop.lessons = lessonsOOP;
		
		
		Course db = new Course("BD ", 3, 4);
		Set<Lesson> lessonsDB = new HashSet<Lesson>();
		Lesson lectureDB = new Lesson(LessonType.LECTURE, 120, 444, new TimeSlot(WeekDay.SAT, LocalTime.of(17, 00, 00), LocalTime.of(19, 00, 00)));
		Lesson practiceDB  = new Lesson(LessonType.PRACTICE, 60, 269, new TimeSlot(WeekDay.WED, LocalTime.of(13, 00, 00), LocalTime.of(14, 00, 00)));
		lessonsDB.add(lectureDB);
		lessonsDB.add(practiceDB);
		db.lessons = lessonsDB;

		
		Course ict = new Course("ICT", 4, 4);
		Set<Lesson> lessonICT = new HashSet<Lesson>();
		Lesson lectureICT = new Lesson(LessonType.LECTURE, 120, 445, new TimeSlot(WeekDay.TUE, LocalTime.of(16, 00, 00), LocalTime.of(18, 00, 00)));
		Lesson practiceICT = new Lesson(LessonType.PRACTICE, 60, 269, new TimeSlot(WeekDay.FRI, LocalTime.of(14, 00, 00), LocalTime.of(15, 00, 00)));
		lessonICT.add(lectureICT);
		lessonICT.add(practiceICT);
		ict.lessons = lessonICT;
		
		
		Course rus = new Course("Rus", 3, 3);
		Set<Lesson> lessonRus = new HashSet<Lesson>();
		Lesson practiceRus1 = new Lesson(LessonType.PRACTICE, 60, 355, new TimeSlot(WeekDay.MON, LocalTime.of(11, 00, 00), LocalTime.of(12, 00, 00)));
		Lesson practiceRus2 = new Lesson(LessonType.PRACTICE, 60, 355, new TimeSlot(WeekDay.WED, LocalTime.of(11, 00, 00), LocalTime.of(12, 00, 00)));
		Lesson practiceRus3 = new Lesson(LessonType.PRACTICE, 60, 355, new TimeSlot(WeekDay.FRI, LocalTime.of(11, 00, 00), LocalTime.of(12, 00, 00)));
		lessonRus.add(practiceRus1);
		lessonRus.add(practiceRus2);		
		lessonRus.add(practiceRus3);
		rus.lessons = lessonRus;
		
		
		Course glob = new Course("Globa", 3, 3);
		Set<Lesson> lessonGlob = new HashSet<Lesson>();
		Lesson lectureGlob = new Lesson(LessonType.LECTURE, 120, 16, new TimeSlot(WeekDay.TUE, LocalTime.of(10, 00, 00), LocalTime.of(12, 00, 00)));
		Lesson practiceGlob = new Lesson(LessonType.PRACTICE, 60, 301, new TimeSlot(WeekDay.FRI, LocalTime.of(15, 00, 00), LocalTime.of(16, 00, 00)));
		lessonGlob.add(lectureGlob);
		lessonGlob.add(practiceGlob);
		glob.lessons = lessonGlob;

		
		Course web = new Course("WEB", 3, 3);
		Set<Lesson> lessonWeb = new HashSet<Lesson>();
		Lesson lectureWeb = new Lesson(LessonType.LECTURE, 120, 434, new TimeSlot(WeekDay.THUR, LocalTime.of(10, 00, 00), LocalTime.of(12, 00, 00)));
		Lesson practiceWeb = new Lesson(LessonType.PRACTICE, 60, 301, new TimeSlot(WeekDay.THUR, LocalTime.of(15, 00, 00), LocalTime.of(16, 00, 00)));
		lessonWeb.add(lectureWeb);
		lessonWeb.add(practiceWeb);
		web.lessons = lessonWeb;

		
		// -----------Departments-----------------
		
		Department fit = new Department("FIT");
		Department mcm = new Department("MCM");
		

		
		// ------------Teachers------------------
		
		User pakitaUser = new Teacher(new BasicUser(), "Pakita San", "p.shamoi", "Password1", 10000, fit, TeacherLevel.PROFESSOR, new Rate(0, 0));
		Teacher pakita = (Teacher) pakitaUser;
		
		User amanovUser = new Teacher(new BasicUser(), "Alim Amanov", "a.amanov", "Password2", 9000, fit, TeacherLevel.PROFESSOR, new Rate(0, 0));
		Teacher amanov = (Teacher) amanovUser;
		
		User chardonUser = new Teacher(new BasicUser(), "Gaetan Chardon", "g.chardon", "Password3", 7000, fit, TeacherLevel.PROFESSOR, new Rate(0, 0));
		Teacher chardon = (Teacher) chardonUser;
		
		User kuralbayevUser = new Teacher(new BasicUser(), "Aibek Kuralbayev", "a.kuralbayev", "Password4", 7000, fit, TeacherLevel.SENIOR_LECTURER, new Rate(0, 0));
		Teacher kuralbayev = (Teacher) kuralbayevUser;
		
		User boburUser = new Teacher(new BasicUser(), "Bobur Mukhsimbayev", "b.mukhsimbayev", "Password4", 7000, fit, TeacherLevel.SENIOR_LECTURER, new Rate(0, 0));
		Teacher bobur = (Teacher) boburUser;


		
		
		// --------------Managers---------------------
		
		User kaidarovaUser = new Manager(new BasicUser(), "Nazym Kaidarova", "n.kaidarova", "Passswwword", 8000, ManagerTypes.FACULTY, fit); 
		Manager kaidarova = (Manager) kaidarovaUser;
		
		User danaUser = new Manager(new BasicUser(), "Dana Akhmetzhanova", "d.akhmetzhanova", "Passswwword", 8000, ManagerTypes.FACULTY, fit); 
		Manager dana = (Manager) danaUser;
		
		User azamatUser = new Manager(new BasicUser(), "Azamat Imanbayev", "a.imanbayev", "Passswwword", 8000, ManagerTypes.FACULTY, fit); 
		Manager azamat = (Manager) azamatUser;
		
		
		// --------------Admin---------------------
		User adminUser = new Admin(new BasicUser(), "Adminbek Adminzhanov", "a.adminzhanov", "Passswworrd", 9000);
		Admin admin = (Admin) adminUser;
		
		
		
		// -------------Librarian--------------------
		User librarianUser = new Librarian(new BasicUser(), "Libgulya Libova", "l.libova", "Passowrrd1", 5000);
		Librarian librarian = (Librarian) librarianUser;
		
		
		// ---------------Books-------------------
		Book book1 = new Book("OOP", "Pakita");
		Book book2 = new Book("Intro to Algorithms", "Cormen");
		Book book3 = new Book("Grokking System Design", "Merey");
		
		
		// ----------Students-------------
		User abylaiUser = new Student(new BasicUser(), "Abylai Amirov", "a_amirov", "Passssword", StudentLevel.MASTER, 1, fit, new Speciality("Intellectual Systems"));
		Student abylai = (Student) abylaiUser;
		
		User zhantoreUser = new Student(new BasicUser(), "Zhantore Svanov", "z_svanov", "Passssword", StudentLevel.BACHELOR, 2, fit, new Speciality("Information Systems"));
		Student zhantore = (Student) zhantoreUser;
		
		User zhanserikUser = new Student(new BasicUser(), "Zhanserik Kalmukhambet", "z_kalmukhambet", "paASsasa", StudentLevel.BACHELOR, 2, fit, new Speciality("Information Systems"));
		Student zhanserik = (Student) zhanserikUser;
		
		
		// ------------------Registration Course----------------
		
		Librarian.addBookToLibrary(book1);
		Librarian.addBookToLibrary(book2);
		Librarian.addBookToLibrary(book3);

		Department.depatments.add(fit);
		Department.depatments.add(mcm);
		
		Database.users.add(kaidarova);
		Database.users.add(dana);
		Database.users.add(azamat);


		Database.users.add(admin);
		Database.users.add(librarian);
		

		
		Manager.addCourseForRegistration(ads);
		Manager.addCourseForRegistration(oop);
		Manager.addCourseForRegistration(db);
		Manager.addCourseForRegistration(ict);
		Manager.addCourseForRegistration(rus);
		Manager.addCourseForRegistration(glob);
		
		System.out.println("added ADS: " + zhantore.registerCourse(ads));
		System.out.println("added OOP: " + zhantore.registerCourse(oop));
		System.out.println("added DB: " + zhantore.registerCourse(db));
		System.out.println("added ICT: " + zhantore.registerCourse(ict));
		System.out.println("added RUS: " + zhantore.registerCourse(rus));
		System.out.println("added Globa: " + zhantore.registerCourse(glob));

		pakita.courses.add(oop);
		amanov.courses.add(ads);
		chardon.courses.add(ict);
		kuralbayev.courses.add(db);
		kuralbayev.courses.add(web);
		bobur.courses.add(web);
		
		
		
		System.out.println("put mark to: " + pakita.putMark(zhantore, oop, new Mark(30, 0, 0)));
		
		
		Admin.addUser(abylai);
		Admin.addUser(zhantore);
		Admin.addUser(zhanserik);
		
		Database.users.add(pakita);
		Database.users.add(amanov);
		Database.users.add(chardon);
		Database.users.add(kuralbayev);
		Database.users.add(bobur);
		
		Database.serializeAll();
		
//		User mereyUser = new Student(new BasicUser(), "Merey Polatkhan", "m_polatkhan", "hihihi11jH", StudentLevel.BACHELOR, 2, fit, new Speciality("Information Systems"));
//		System.out.println(mereyUser);
//		mereyUser = new ResearcherDecorator(mereyUser);
//		System.out.println(mereyUser);
	}
}
