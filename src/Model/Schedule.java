package Model;

import java.util.*;

public class Schedule {
	public Vector<Course> courses;
	
	public Schedule(Vector<Course> courses) {
		this.courses = courses;
	}
	
	public void generateSchedule() {
		Map<Date, Lesson> allLessons = new HashMap<Date, Lesson>() ;
		
		for (Course course: courses) {
			for (Map.Entry<Date, Lesson> entry: course.lessons.entrySet()) {
				Date Date = entry.getKey();
				Lesson lesson = entry.getValue();
				allLessons.put(Date, lesson);
			}
		}
		
		Vector<Lesson> mondayLessons = new Vector<Lesson>();
		Vector<Lesson> tuesdayLessons = new Vector<Lesson>();
		Vector<Lesson> wednesdayLessons = new Vector<Lesson>();
		Vector<Lesson> thursdayLessons = new Vector<Lesson>();
		Vector<Lesson> fridayLessons = new Vector<Lesson>();
		Vector<Lesson> saturdayLessons = new Vector<Lesson>();
		Vector<Lesson> sundayLessons = new Vector<Lesson>();
		
		for (Map.Entry<Date, Lesson> entry: allLessons.entrySet()) {
			Date wd = entry.getKey();
			Lesson lesson = entry.getValue();
			if (wd.day == WeekDay.MON) {
				mondayLessons.add(lesson);
			}
			else if (wd.day == WeekDay.TUE) {
				tuesdayLessons.add(lesson);
			}
			else if (wd.day == WeekDay.WED) {
				wednesdayLessons.add(lesson);
			}
			else if (wd.day == WeekDay.THUR) {
				thursdayLessons.add(lesson);
			}
			else if (wd.day == WeekDay.FRI) {
				fridayLessons.add(lesson);
			}
			else if (wd.day == WeekDay.SAT) {
				saturdayLessons.add(lesson);
			}
			else if (wd.day == WeekDay.SUN) {
				sundayLessons.add(lesson);
			}
		}
		
		System.out.println("MONDAY LESSONS: ");
		for (Lesson lesson: mondayLessons) {
			System.out.println();
		}	
	}
	
	
	
	
	public String toString() {
		
	}
	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (o == null) {
			return false;
		}
		if (o.getClass() != this.getClass()) {
			return false;
		}
		
	}
	
	public int hashCode() {
		
	}
	
	public int compareTo() {
		
	}
	public Object clone() throws CloneNotSupportedException {
		
	}
}
