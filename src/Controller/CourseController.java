package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import Config.Database;
import Model.Course;
import Model.Department;
import Model.ElectiveCourseType;
import Model.Lesson;
import Model.LessonType;
import Model.Speciality;
import Model.TimeSlot;
import Model.WeekDay;

public class CourseController {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static Course createCourse() {

		Course course = new Course();
		
		System.out.println("Please write course name: ");		
		try {
			String courseName = (br.readLine()).trim();
			course.courseName = courseName;
		} catch (IOException e) {
			System.out.println("Provided incorrect data");
			e.printStackTrace();
		}
		
		System.out.println("Please write code: ");
		try {
			int code = Integer.parseInt(br.readLine());
			course.code = code;
		} catch (NumberFormatException | IOException e) {
			System.out.println("Provided incorrect type, please write int type");
			e.printStackTrace();
		}
		
		System.out.println("Please write credits: ");
		
		try {
			int credits = Integer.parseInt(br.readLine());
			course.credits = credits;
		} catch (NumberFormatException | IOException e) {
			System.out.println("Provided incorrect type, please write int type");
			e.printStackTrace();
		}
		
		
		System.out.println("How many prerequisites does course have: ");
		try {
			int quantity = Integer.parseInt(br.readLine());
			if (quantity > 0) {
				Vector<Course> prereqs = new Vector<Course>();
				for (int i = 1; i <= quantity; i++) {
					System.out.println("Please write name of " + i + "-course");
					String curCourseName = (ManagerController.br.readLine()).trim();
					for (Course c: Database.registrationCourses) {
						if (c.courseName.equals(curCourseName)) {
							prereqs.add(c);
							System.out.println(i + "-course added succesfully");
							break;
						}
					}
					
				}
				course.prerequisites = prereqs;
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Provided incorrect type, please write int type");
			e.printStackTrace();
		}
		
		System.out.println("provide department name: ");
		try {
			String depName = br.readLine().trim();
			boolean depExists = false;
			for (Department d: Department.depatments) {
				if (d.name.equals(depName)) {
					depExists = true;
					course.department = d;
					break;
				}
			
			}
			if (!depExists) course.department = DepartmentController.createDepartment();
		} catch (IOException e) {
			System.out.println("incorrect something");
			e.printStackTrace();
		}


		System.out.println("Please prodive speciality name: ");			
		try {
			String specName =  (br.readLine()).trim();
			course.intendedSpeciality = new Speciality(specName);
		} catch (IOException e) {
			System.out.println("Provided incorrect data");
			e.printStackTrace();
		}
		
		System.out.println("Please prodive info about this course: ");			
		try {
			String information =  (ManagerController.br.readLine()).trim();
			course.info = information;
		} catch (IOException e) {
			System.out.println("Provided incorrect data");
			e.printStackTrace();
		}
		
		System.out.println("Please prodive type of elective about this course: 1.Free \n2.Major \n3.Must \4.Undefined");
		try {
			int typElec = Integer.parseInt(br.readLine());
			if (typElec == 1) {
				course.type = ElectiveCourseType.FREE;
			}
			else if (typElec == 2) {
				course.type = ElectiveCourseType.MAJOR;
			}
			else if (typElec == 3) {
				course.type = ElectiveCourseType.MUST;
			}
			else {
			}
		} catch (NumberFormatException | IOException e) {
			System.out.println("Provided incorrect type, please write int type");
			e.printStackTrace();
		}
		
		Set<Lesson> courseLessons = new HashSet<Lesson>();
		System.out.println("How many lessons will be in 1 week: ");
		try {
			int cntLesson = Integer.parseInt(br.readLine());
			for (int i = 1; i <= cntLesson; i++) {
				Lesson lesson = new Lesson();
				System.out.println("Provide " + i + "-lesson type: 1.Lab\n2.Lecture\n3.Practice");
				int lessonType = Integer.parseInt(br.readLine());
				if (lessonType == 1) {
					lesson.type = LessonType.LAB;
				}
				else if (lessonType == 2) {
					lesson.type = LessonType.LECTURE;
				}
				else{
					lesson.type = LessonType.PRACTICE;
				}
				
				System.out.println("Provide " + i + "-lesson duration in minutes");
				lesson.duration = Integer.parseInt(br.readLine());
				
				System.out.println("Provide " + i + "-lesson cabinet");
				lesson.cabinet = Integer.parseInt(br.readLine());
				
				TimeSlot tm = new TimeSlot();
				System.out.println("Provide " + i + "-lesson week day in number 1-7 : MON-SUN: ");
				int dayNum = Integer.parseInt(br.readLine());
				if (dayNum == 1) tm.day = WeekDay.MON;
				if (dayNum == 2) tm.day = WeekDay.TUE;
				if (dayNum == 3) tm.day = WeekDay.WED;
				if (dayNum == 4) tm.day = WeekDay.THUR;
				if (dayNum == 5) tm.day = WeekDay.FRI;
				if (dayNum == 6) tm.day = WeekDay.SAT;
				if (dayNum == 7) tm.day = WeekDay.SUN;
				
				System.out.println("Provide " + i + "-lesson timeSlot beginTime hour: ");
				int tmHour = Integer.parseInt(br.readLine());
				System.out.println("Provide " + i + "-lesson timeSlot beginTime minute: ");
				int tmMin = Integer.parseInt(br.readLine());
				tm.begin = LocalTime.of(tmHour, tmMin, 0);
				
				System.out.println("Provide " + i + "-lesson timeSlot endTime hour: ");
				tmHour = Integer.parseInt(br.readLine());
				System.out.println("Provide " + i + "-lesson timeSlot endTime minute: ");
				tmMin = Integer.parseInt(br.readLine());
				tm.end = LocalTime.of(tmHour, tmMin, 0);
				
				lesson.timeSlot = tm;
				
				courseLessons.add(lesson);
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		course.lessons = courseLessons;
		Database.registrationCourses.add(course);
		return course;
	}
}
