package Model;

import java.io.Serializable;
import java.util.Objects;

public class Lesson implements Comparable<Lesson>, Cloneable, Serializable{
	public LessonType type;
	public int duration;
	public int cabinet;
	public TimeSlot timeSlot;

	public Lesson() {}
	
	public Lesson(LessonType type, int duration, int cabinet, TimeSlot timeSlot) {
		this.type = type;
		this.duration = duration;
		this.cabinet = cabinet;
		this.timeSlot = timeSlot;
	}
	
	public String toString() {
		return "Lesson: " + type + ", " + duration + " min, cab: " +  cabinet + ", " + timeSlot;
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
		Lesson lesson = (Lesson)o;
		return lesson.type == this.type && 
				lesson.duration == this.duration && 
				lesson.cabinet == this.cabinet && 
				lesson.timeSlot.equals(this.timeSlot);
	}
	
	public int hashCode() {
		return Objects.hash(type, duration, cabinet, timeSlot);
	}
	
	public Object clone() {
		Lesson newLesson = new Lesson();
		newLesson.type = this.type;
		newLesson.duration = this.duration;
		newLesson.cabinet = this.cabinet;
		newLesson.timeSlot = (TimeSlot) this.timeSlot.clone();
		return newLesson;
	}

	
	@Override
	public int compareTo(Lesson lesson) {
		return this.timeSlot.compareTo(lesson.timeSlot);
	}
	
	
}
