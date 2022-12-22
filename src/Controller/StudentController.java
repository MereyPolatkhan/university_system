package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

import Config.Database;
import Model.*;
import View.*;

public class StudentController extends UserController {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public Student model;
	public StudentView view;
	
	public StudentController(Student model, StudentView view) {
		this.model = model;
		this.view = view;
	}
	
	
	
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
				if (d.name.equals(depName)) {
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
	
	
	public void viewScholarship() {
		System.out.println(model.getScholarship());
	}
	
	public void viewSchedule() {
		model.getSchedule().generateSchedule(model.viewCourses());
		model.getSchedule().showSchedule();
	}
	
	public void viewCourseAndMarks() {
		for(Map.Entry<Course, Mark> entry: model.getCoursesMarks().entrySet()) {
			System.out.println(entry.getKey().courseName + ": " + entry.getValue().getTotal().digitGrade);
		}
	}
	
	public void viewTranscript() {
		for (Attestation att: model.getTranscript().attestations) {
			System.out.println(att.period);
			for (Map.Entry<Course, Mark> entry: att.courses.entrySet()) {
				System.out.println(entry.getKey().courseName + " ---- " + entry.getValue().getTotal());
			}
			System.out.println("--------------------------------------------");
		}
		
	}
	
	public void registerCourse() {
		try {
			System.out.println("Please provide course name: ");
			String courseName = br.readLine().trim();
			for (Course c: Database.registrationCourses) {
				if (c.courseName.equals(courseName)) {
					if (model.registerCourse(c)) {
						System.out.println("Successfully added");
						return;
					}
					System.out.println("Something Happened wrong");
					return;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getTeachersInfo() {
		try {
			System.out.println("Please provide course name: ");
			String courseName = br.readLine().trim();
			for (Course c: Database.registrationCourses) {
				if (c.courseName.equals(courseName)) {
					for (Teacher teacher: model.getTeachers(c)) {
						System.out.println(teacher);
					}
					return;
				}
			}
			System.out.println("That course doesnt exist in DB");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}
	
	public void viewMarks() {
		try {
			System.out.println("Please provide course name: ");
			String courseName = br.readLine().trim();
			for (Course c: model.viewCourses()) {
				if (c.courseName.equals(courseName)) {
					System.out.println(model.viewMarks(c));
				}
			}
			System.out.println("Currently this course is not in students journal");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void viewCourses() {
		for (Course c: model.viewCourses()) {
			System.out.println(c);
		}
	}
	
	public void rateTeacher() {
		try {
			System.out.println("write teacher name: ");
			String nameTeacher = br.readLine().trim();
			for (Teacher teacher: Database.getTeachersFromDB()) {
				if (teacher.firstLastName.equals(nameTeacher)) {
					double point = Double.parseDouble(br.readLine().trim());
					model.rateTeacher(teacher, point);
					return;
				}
			}
			System.out.println("TEacher is not in DB");
			return;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public void writeDiplomaProject() {
		
	}
	
	public void viewCurrentGpa() {
		System.out.println(model.getCurrentGPA());
	}
	
	public void viewGeneralGpa() {
		System.out.println(model.getGeneralGpa());
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
			System.out.println("Welcome Student " + model.firstLastName);
			menu: while (true) {
				System.out.println("What do you want to do?\n "
						+ "1) view Scholarship \n "
						+ "2) view Schedule  \n "
						+ "3) view Course And Marks  \n "
						+ "4) view Transcript\n "
						+ "5) register Course \n "
						+ "6) get Teachers Info \n "
						+ "7) view Marks \n "
						+ "8) view Courses \n "
						+ "9) rate Teacher \n "
						+ "10) write Diploma Project \n "
						+ "11) view Current Gpa  \n "
						+ "12) view General Gpa \n "
						+ "13) Become Researcher or update H-index \n "
						+ "14) show Researcher Info \n "
						+ "15) add researcher paper \n"
						+ "16) add researcher project \n"
						+ "17) see news \n"
						+ "18) exit ");
				int choice = Integer.parseInt(br.readLine());
				if (choice == 1) {
					viewScholarship: while(true){
						viewScholarship();
						System.out.println("\n 1) view Scholarship  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewScholarship;
						if(choice==2) continue menu;
						if(choice==3) {exit(); break menu;}
						break;
					}
				}
				else if (choice == 2) {
					viewSchedule: while(true){
						viewSchedule();
						System.out.println("\n 1) view Schedule \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewSchedule;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 3) {
					viewCourseAndMarks: while(true){
						viewCourseAndMarks();
						System.out.println("\n 1) view Course And Marks  \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewCourseAndMarks;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 4) {
					viewTranscript: while(true){
						viewTranscript();
						System.out.println("\n 1) viewTranscript \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewTranscript;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 5) {
					registerCourse: while(true){
						registerCourse();
						System.out.println("\n 1) register Course \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue registerCourse;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 6) {
					getTeachersInfo: while(true){
						getTeachersInfo();
						System.out.println("\n 1) get Teachers Info \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue getTeachersInfo;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				else if (choice == 7) {
					viewMarks: while(true){
						viewMarks();
						System.out.println("\n 1) view Marks \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewMarks;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 8) {
					viewCourses: while (true) {
						viewCourses();
						System.out.println("\n 1) view Courses \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewCourses;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 9) {
					rateTeacher: while (true) {
						rateTeacher();
						System.out.println("\n 1) rateTeacher \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue rateTeacher;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 10) {
					writeDiplomaProject: while (true) {
						writeDiplomaProject();
						System.out.println("\n 1) write Diploma Project \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue writeDiplomaProject;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice == 11) {
					viewCurrentGpa: while (true) {
						viewCurrentGpa();
						System.out.println("\n 1) view Current Gpa \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewCurrentGpa;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				
				else if (choice == 12) {
					viewGeneralGpa: while (true) {
						viewGeneralGpa();
						System.out.println("\n 1) view General Gpa \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue viewGeneralGpa;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				else if (choice==13){
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
				else if (choice==14){
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
				
				else if (choice==15){
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
				
				else if (choice==16){
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
				
				

				else if (choice==17){
					seeNews: while(true){
						seeNews();
						System.out.println("\n 1) see News \n 2) Return back \n 3) Exit");
						choice = Integer.parseInt(br.readLine());
						if(choice==1) continue seeNews;
						if(choice==2) continue menu;
						if(choice==3) {exit();  break menu;}
						break;
					}
				}
				
				
				else if (choice == 18) {
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
