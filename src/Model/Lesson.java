package Model;

public class Lesson {
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
}
