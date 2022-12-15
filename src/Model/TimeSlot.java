package Model;

import java.time.LocalTime;

public class TimeSlot {
	public WeekDay day;
	public LocalTime begin;
	public LocalTime end;
	
	public TimeSlot() {}

	public TimeSlot(WeekDay day, LocalTime begin, LocalTime end) {
		this.day = day;
		this.begin = begin;
		this.end = end;
	}
		
}
