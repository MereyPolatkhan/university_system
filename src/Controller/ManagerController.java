package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import Config.Database;
import Model.*;
import View.*;

public class ManagerController {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public Manager model;
	public ManagerView view;
	
	public ManagerController(Manager model, ManagerView view) {
		this.model = model;
		this.view = view;
	}
	
	public static Manager createManager() {
		Manager manager = (Manager) UserFactory.createUser("Manager");
		System.out.println("provide department name: ");
		try {
			String depName = br.readLine().trim();
			boolean depExists = false;
			for (Department d: Department.depatments) {
				if (d.name == depName) {
					depExists = true;
					manager.department = d;
					break;
				}
			
			}
			if (!depExists) manager.department = DepartmentController.createDepartment();
		} catch (IOException e) {
			System.out.println("incorrect something");
			e.printStackTrace();
		}
		
		System.out.println("Assign salary: ");
		try {
			manager.setSalary(Double.parseDouble(br.readLine()));
		} catch (NumberFormatException | IOException e) {
			System.out.println("Provided incorrect type, please write appropriate type");
			e.printStackTrace();
		}
		
		System.out.println("Provide manager type: 1.OR, 2.DEAN, 3.RECTOR, 4.FACULTY;");
		try {
			int type = Integer.parseInt(br.readLine());
			if (type == 1) manager.type = ManagerTypes.OR;
			if (type == 2) manager.type = ManagerTypes.DEAN;
			if (type == 3) manager.type = ManagerTypes.RECTOR;
			if (type == 4) manager.type = ManagerTypes.FACULTY;
			
		} catch (NumberFormatException | IOException e) {
			System.out.println("Provided incorrect type, please write appropriate type");
			e.printStackTrace();
		}
		
		Database.users.add(manager);
		return manager;

	}
	
	
	

	public static boolean addCourseForRegistration() {
		Course course = CourseController.createCourse();
		
		
		if (Manager.addCourseForRegistration(course)) {
			System.out.println("Course successfully added to registration");
			return true;
		}
		return false;
        
    }
    
    public void createStatisticalReportOnAcademicPerformance() {
    	Student student = new Student(new BasicUser());
    	System.out.println("Please provide student name: ");
    	String name = "";
		try {
			name = br.readLine().trim();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	boolean studentExists = false;
    	for (Student s: Database.getStudentsFromDB()) {
    		if (s.firstLastName == name) {
    			studentExists = true;
    			student = s;
    			break;
    		}
    	}
    	if (studentExists) Manager.createStatisticalReportOnAcademicPerformance(student);
    	else System.out.println("Database doesnt contain this Student. You have to create student");
    }
    
    
    
    public void viewInfoAboutStudents() throws CloneNotSupportedException {
    	Vector<Student> students = Database.getStudentsFromDB();
    	System.out.println("how sorted info do u wanna see: 1.GPA\n 2.Year");
    	int how = 0;
		try {
			how = Integer.parseInt(ManagerController.br.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if (how == 1) {
    		students = this.model.viewInfoAboutStudents(HowToSort.GPA);
    	}
    	else if (how == 2) {
    		students = this.model.viewInfoAboutStudents(HowToSort.YEAR);
    	}
    	
    	StudentView.showStudent(students);
    }
    
    public void viewInfoAboutTeachers() throws CloneNotSupportedException {
    	Vector<Teacher> teachers = Database.getTeachersFromDB();
    	System.out.println("how sorted info do u wanna see: 1.SALARY\n 2.RATE");
    	int how = 0;
		try {
			how = Integer.parseInt(ManagerController.br.readLine());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if (how == 1) {
    		teachers = this.model.viewInfoAboutTeachers(HowToSort.SALARY);
    	}
    	else if (how == 2) {
    		teachers = this.model.viewInfoAboutTeachers(HowToSort.RATE);
    	}
    	
    	TeacherView.showTeacher(teachers);
    }
    
    public void viewSignedRequests() {
    	Vector<Request> req =  model.viewSignedRequests();
    	if (req.size() == 0) {
    		System.out.println("Any requests have not been signed by Rector/Dean");
    		return;
    	}
    	RequestView.showRequests(req);
    }
    
    public static boolean assignCoursesToTeachers() {
    	Vector<Course> courses = new Vector<Course>();
    	Vector<Teacher> teachers = new Vector<Teacher>();
    	
    	System.out.println("How many courses do you wanna assign: ");
    	try {
			int howMany = Integer.parseInt(ManagerController.br.readLine());
			for (int i = 1; i <= howMany; i++) {
				System.out.println("write " + i + "-course name: ");
				String name = (ManagerController.br.readLine()).trim();
				for (Course c: Database.registrationCourses) {
					if (c.courseName == name) {
						courses.add(c);
						break;
					}
				}
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("incorrect format");
			e.printStackTrace();
		}
    	
    	
    	
    	System.out.println("how many teachers do you wanna to be assigned by these courses: ");
    	try {
			int howMany = Integer.parseInt(ManagerController.br.readLine());
			for (int i = 1; i <= howMany; i++) {
				System.out.println("write " + i + "-teacher's name: ");
				String name = (ManagerController.br.readLine()).trim();
				for (Teacher t: Database.getTeachersFromDB()) {
					if (t.firstLastName == name) {
						teachers.add(t);
						break;
					}
				}
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("incorrect format");
			e.printStackTrace();
		}
    	
    	
    	if (Manager.assignCoursesToTeachers(courses, teachers)) {
    		System.out.println("Courses successfully assigned");
    		return true;
    	}
    	System.out.println("Any Course hasnt been added");
    	return false;
    }

    public News createNews() {
    	News news = new News();
    	System.out.println("write news header: ");
    	try {
			String header = (ManagerController.br.readLine()).trim();
			news.header = header;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	System.out.println("write news description: ");
    	try {
			String descr = (ManagerController.br.readLine()).trim();
			news.description = descr;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	return news;
    	
    }	
    
	public boolean addNews() {
		News news = createNews();
		if (model.addNews(news)) {
			System.out.println("News added successfully");
		}
		System.out.println("Please, manager, try again");
		return false;
	}

	public boolean deleteNews() {
		System.out.println("write header of news that u wanna delete: ");
		try {
			String header = (ManagerController.br.readLine()).trim();
			for (News n: News.news) {
				if (n.header == header) {
					if (model.deleteNews(n)) {
						System.out.println("News deleted successfully");
						return true;
					}
					System.out.println("Database doesnt have such news");
					return false;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Please, manager, try again");
		return false;
	}


	
	private void save() {
		Database.serializeAll();
	}
	
	private void exit() {
		System.out.println("Bye bye");
		save();
	}
	
	
	void run() {
		try {
			System.out.println("Welcome");
			menu: while (true) {
				System.out.println("What do you want to do?\n 1) Add Course For Registration \n 2) View Info About Students  \n 3) View Info About Teachers  \n 4) View Signed Requests \n 5) Assign Courses To Teachers \n 6) Add News 7) Delete News \n 8) add student \n 9)Exit");
				int choice = Integer.parseInt(ManagerController.br.readLine());
				if (choice == 1) {
					addCourseForRegistration: while(true){
						addCourseForRegistration();
						System.out.println("\n 1) Add another course for registration  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(ManagerController.br.readLine());
						if(choice==1) continue addCourseForRegistration;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice == 2) {
					viewInfoAboutStudents: while(true){
						viewInfoAboutStudents();
						System.out.println("\n 1) view again students  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(ManagerController.br.readLine());
						if(choice==1) continue viewInfoAboutStudents;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 3) {
					viewInfoAboutTeachers: while(true){
						viewInfoAboutTeachers();
						System.out.println("\n 1) view again teachers  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(ManagerController.br.readLine());
						if(choice==1) continue viewInfoAboutTeachers;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 4) {
					viewSignedRequests: while(true){
						viewSignedRequests();
						System.out.println("\n 1) view Signed Requests again \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(ManagerController.br.readLine());
						if(choice==1) continue viewSignedRequests;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 5) {
					assignCoursesToTeachers: while(true){
						assignCoursesToTeachers();
						System.out.println("\n 1) Assign Courses To Teachers \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(ManagerController.br.readLine());
						if(choice==1) continue assignCoursesToTeachers;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 6) {
					addNews: while(true){
						addNews();
						System.out.println("\n 1) Add News \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(ManagerController.br.readLine());
						if(choice==1) continue addNews;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 7) {
					deleteNews: while(true){
						deleteNews();
						System.out.println("\n 1) Delete News \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(ManagerController.br.readLine());
						if(choice==1) continue deleteNews;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 8) {
					addStudent: while (true) {
						StudentController.createStudent();
						System.out.println("\n 1) add student again \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(ManagerController.br.readLine());
						if(choice==1) continue addStudent;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 9) {
					exit();
					break menu;
				}
			}
		} catch (Exception e) {
			System.out.println("Something bad happened... \n Saving resources...");
			e.printStackTrace();
			save();
		}
	}
	
	
}
