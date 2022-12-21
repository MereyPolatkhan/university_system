package Model;


import java.io.Serializable;
import java.time.*;
import java.util.*;


public class Journal implements Serializable{
	public Map<Course, TreeMap<LocalDate, Pair<Boolean, Double>>> courseAttendanceAndPoints;
	
	public Journal() {
		courseAttendanceAndPoints = new HashMap<Course, TreeMap<LocalDate, Pair<Boolean, Double>>> ();
	}
	
	public void showTotal(Course course) {
		if (courseAttendanceAndPoints.containsKey(course)) {
			TreeMap<LocalDate, Pair<Boolean, Double>> courseInfo = courseAttendanceAndPoints.get(course);
			for (Map.Entry<LocalDate, Pair<Boolean, Double>> entry: courseInfo.entrySet()) {
				System.out.println(entry.getKey() + " -- attended: " + entry.getValue().first + " mark: " + entry.getValue().second);
			}
		} else {
			System.out.println("Student doesnt have such course");
		}
		
	}
}
