package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import Config.Database;
import Model.BasicUser;
import Model.Course;
import Model.Department;
import Model.Manager;
import Model.Mark;
import Model.Rate;
import Model.Schedule;
import Model.Student;
import Model.Teacher;
import Model.TeacherCourseFile;
import Model.TeacherLevel;
import Model.UserFactory;
import View.CourseView;
import View.ManagerView;
import View.NewsView;
import View.StudentView;
import View.TeacherView;

public class TeacherController extends UserController {
	

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
				if (d.name.equals(depName)) {
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
		
		System.out.println("Please provide student login: ");
		
		boolean studentExists = false;
		try {
			String login = br.readLine().trim();
			for (Student s: Database.getStudentsFromDB()) {
				if (s.login.equals(login)) {
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
				if (c.courseName.equals(courseName)) {
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
	
	public void showSchedule() {
		Schedule schedule = new Schedule();
		schedule.generateSchedule(this.model.courses);
		schedule.showSchedule();
	}
	
	public boolean putAttendance() {
		int year = 0, month = 0, day = 0;
		System.out.println("Please provide followed datas: ");
		System.out.println("provide year: ");
		try {
			 year = Integer.parseInt(br.readLine().trim());
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("provide month: ");
		try {
			 month = Integer.parseInt(br.readLine().trim());
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("provide Day of month: ");
		try {
			 day = Integer.parseInt(br.readLine().trim());
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LocalDate date = LocalDate.of(year, month, day);
		
		
		Student student = new Student(new BasicUser());
		
		System.out.println("Please provide student name: e.g 'Merey Polatkhan' ");
		
		boolean studentExists = false;
		try {
			String name = br.readLine().trim();
			for (Student s: Database.getStudentsFromDB()) {
				if (s.firstLastName.equals(name)) {
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
				return false;
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
				if (c.courseName.equals(courseName)) {
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
				return false;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		double mark = 0;
		System.out.println("Please provide mark: e.g: 3.4");
		try {
			mark = Integer.parseInt(br.readLine().trim());
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (model.putAttendance(date, student, course, mark)) {
			System.out.println("Attendance put successsfully");
			return true;
		}
		System.out.println("ups , something happened");
		return false;
		
	}
	
	
	public void addCourseFile() {
		System.out.println("Student exists, now pls provide course name: ");

		Course course = new Course();
		
		try {
			String courseName = br.readLine().trim();
			boolean courseExists = false;
			for (Course c: Database.registrationCourses) {
				if (c.courseName.equals(courseName)) {
					courseExists = true;
					course = c;
					break;
				}
			}
			if (!courseExists) {
				System.out.println("Course doesnt exists in system, try to add from manager");
				return;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		TeacherCourseFile tcf = new TeacherCourseFile();
		System.out.println("Provide File name: ");
		try {
			String fileName = br.readLine().trim();
			tcf.name = fileName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (model.addCourseFile(course, tcf)) {
			System.out.println("File added successfully");
		}
		else {
			System.out.println("File didnt added(");
		}
		
		
	}
	
	public void deleteCourseFile() {
		try {
			Course course = new Course();
			TeacherCourseFile tcf = new TeacherCourseFile();
			boolean courseExistence = false, tcfExistence = false;
			
			System.out.println("Provide course name: ");
			String courseName = br.readLine().trim();
			System.out.println("Provide file name: ");
			String filename = br.readLine().trim();
			for (Map.Entry<Course, Vector<TeacherCourseFile>> entry: model.courseFiles.entrySet()) {
				if (entry.getKey().courseName.equals(courseName)) {
					course = entry.getKey();
					courseExistence = true;
					for (TeacherCourseFile file: entry.getValue()) {
						if (file.name.equals(filename)) {
							tcf = file;
							tcfExistence = true;
						}
					}
				}
			}
			
			if (courseExistence) {
				if (tcfExistence) {
					if (model.deleteCourseFile(course, tcf)) {
						System.out.println("File deleted successfully");
						return;
					}
					System.out.println("Somethin happened with deleting");
				}
				System.out.println("file doesnt exist");
			}
			System.out.println("Course doesnt exist");
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getRateValue() {
		System.out.println("Teacher Rating: " + model.getRateValue());
	}
	public void becomeResearcher() {
		model.isResearcher = true;
		System.out.println("Now you are researcher please provide h-index: ");
		try {
			model.hIndex = Integer.parseInt(br.readLine());
			System.out.println("You r h index is provided");
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void showResearcher() {
		if (model.isResearcher == false) {
			System.out.println("first you have to become researcher");
		}
		else {
			System.out.println("H-index: " + model.hIndex);
			System.out.println("Research papers: ");
			for (String s: model.researchPapers) {
				System.out.println(s);
			}
			System.out.println("Research projects: ");
			for (String s: model.researchProjects) {
				System.out.println(s);
			}
		}
	}
	
	public void addResearchPaper() {
		try {
			System.out.println("Provide paper: ");
			String paper = br.readLine().trim();
			if (model.addResearchPaper(paper)) {
				System.out.println("Succesfully added");
			}
			else {
				System.out.println("Please become researcher");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addResearchProject() {
		try {
			System.out.println("Provide project: ");
			String project = br.readLine().trim();
			if (model.addResearchProject(project)) {
				System.out.println("Succesfully added");
			}
			else {
				System.out.println("Please become researcher");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			System.out.println("Welcome! " + model.firstLastName);
			menu : while(true){
				System.out.println("What do you want to do?\n "
						+ "1) View Courses \n "
						+ "2) View Students  \n "
						+ "3) Put Mark  \n "
						+ "4) Show Schedule  \n "
						+ "5) Put Attendance \n "
						+ "6) Add Course File \n "
						+ "7) Delete Course File \n "
						+ "8) get Rate Value \n "
						+ "9) Become Researcher \n "
						+ "10) show Researcher Info \n"
						+ "11) add research paper \n "
						+ "12) add research project \n"
						+ "13) see all news \n"
						+ "14) Exit");
				int choice = Integer.parseInt(br.readLine());
				if(choice==1){     
					viewCourses: while(true){
						viewCourses();
						System.out.println("\n 1) View Courses again  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewCourses;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice==2){
					viewStudents: while(true){
						viewStudents();
						System.out.println("\n 1) View Students  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewStudents;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==3){
					putMark: while(true){
						putMark();
						System.out.println("\n 1) Put Mark  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue putMark;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==4){
					showSchedule: while(true){
						showSchedule();
						System.out.println("\n 1) Show Schedule \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue showSchedule;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==5){
					putAttendance: while(true){
						putAttendance();
						System.out.println("\n 1) Put Attendance  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue putAttendance;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==6){
					addCourseFile: while(true){
						addCourseFile();
						System.out.println("\n 1) Add Course File \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue addCourseFile;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==7){
					deleteCourseFile: while(true){
						deleteCourseFile();
						System.out.println("\n 1) Delete Course File \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue deleteCourseFile;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==8){
					getRateValue : while(true){
						getRateValue();
						System.out.println("\n 1) get Rate Value \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue getRateValue ;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==9){
					withResearcher : while(true){
						becomeResearcher();
						System.out.println("\n 1) become Researcher or update h-index \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue withResearcher ;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice==10){
					researcherInfor: while(true){
						showResearcher();
						System.out.println("\n 1) show Researcher Info \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue researcherInfor ;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==11){
					addPaper: while(true){
						addResearchPaper();
						System.out.println("\n 1) add researcher paper \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue addPaper ;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==12){
					addProject: while(true){
						addResearchProject();
						System.out.println("\n 1) add researcher project \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue addProject;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==13){
					printNews: while(true){
						seeNews();
						System.out.println("\n 1) see news \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue printNews;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				
				else if (choice==14){
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
