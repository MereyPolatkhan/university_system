package Model;

import java.io.Serializable;
import java.util.Objects;

import w11LabWork3Problem5.UpdTime;

public class Date implements Comparable<Date>, Cloneable , Serializable{
	public UpdTime time;
	public WeekDay day;
	
	public Date() {}
	public Date(UpdTime time, WeekDay day) {
		this.time = time;
		this.day = day;
	}
	
	public String toString() {
		return "day: " + day + "time: " + time;
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
		Date d = (Date)o;
		return d.time == this.time && d.day == this.day;
	}
	
	public int hashCode() {
		return Objects.hash(time, day);
	}
	
	@Override
	public int compareTo(Date date) {
		if (this.day.ordinal() < date.day.ordinal()) {
			return -1;
		}
		else if (this.day.ordinal() > date.day.ordinal()) {
			return 1;
		} 
		return this.time.compareTo(date.time);
	}
	
	public Object clone() throws CloneNotSupportedException {
		Date newDate = new Date();
		newDate.time = (UpdTime)this.time.clone();
		newDate.day = this.day;
		return newDate;
	}
	
}
