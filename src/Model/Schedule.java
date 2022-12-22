package Model;

import java.io.Serializable;
import java.util.*;

public class Schedule implements Serializable{
	
	TreeMap<Lesson, Course> lessonCourses;
	
	public Schedule() {
		lessonCourses = new TreeMap<Lesson, Course> ();
	}
	
	
	public void generateSchedule(Vector<Course> courses) {
		for (Course course: courses) {
			for (Lesson lesson: course.lessons) {
				lessonCourses.put(lesson, course);
			}
		}
	}
	
	public void showSchedule() {
		for (Map.Entry<Lesson, Course> entry: lessonCourses.entrySet()) {
			Lesson lesson = entry.getKey();
			Course course = entry.getValue();
			System.out.println(lesson.timeSlot.day + "  " + lesson.timeSlot.begin + "-" + lesson.timeSlot.end + "  |  " + course.courseName + " " + lesson.type);
		}
	}
	
	
	
	
	public String toString() {
		return "Schedule courses: " + lessonCourses;
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
		Schedule sch = (Schedule)o;
		return sch.lessonCourses.equals(this.lessonCourses);
	}
	
	public int hashCode() {
		return Objects.hash(lessonCourses);
	}
	
	
	public Object clone() throws CloneNotSupportedException {
		Schedule newSch = new Schedule();
		for (Map.Entry<Lesson, Course> entry: this.lessonCourses.entrySet()) {
			newSch.lessonCourses.put((Lesson)entry.getKey().clone(), (Course)entry.getValue().clone());
		}
		return newSch;
	}
}
