package Model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class TimeSlot implements Cloneable, Comparable<TimeSlot> , Serializable{
	public WeekDay day;
	public LocalTime begin;
	public LocalTime end;
	
	public TimeSlot() {}

	public TimeSlot(WeekDay day, LocalTime begin, LocalTime end) {
		this.day = day;
		this.begin = begin;
		this.end = end;
	}
	
	public String toString() {
		return "TimeSlot: day: " + day + ", begin: " + begin + ", end:" + end;
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
		TimeSlot tm = (TimeSlot)o;
		return tm.day == this.day && 
				tm.begin == this.begin && 
				tm.end == this.end;
	}
	
	public int hashCode() {
		return Objects.hash(day, begin, end);
	}
	
	public Object clone() {
		TimeSlot newTime = new TimeSlot();
		newTime.day = this.day;
		newTime.begin = this.begin;
		newTime.end = this.end;
		return newTime;
	}

	@Override
	public int compareTo(TimeSlot timeslot) {
		if (this.day.ordinal() < timeslot.day.ordinal()) {
			return -1;
		}
		else if (this.day.ordinal() > timeslot.day.ordinal()) { 
			return 1;
		}
		else {
			if (this.begin.compareTo(timeslot.begin) != 0) {
				return this.begin.compareTo(timeslot.begin);
			}
			return this.end.compareTo(timeslot.end) * -1;
		}
	}
		
}
