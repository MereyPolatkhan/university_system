package Model;

import java.time.LocalDate;

public class Grade {
	public double digitGrade;
	public LocalDate datePut;
	
	public Grade() {};
	
	public Grade(double digitGrade, LocalDate datePut) {
		super();
		this.digitGrade = digitGrade;
		this.datePut = datePut;
	}
	
	public String getLetterGrade() {
		if(digitGrade >= 0 && digitGrade < 60) return "F";
		else if(digitGrade < 65) return "D";
		else if(digitGrade < 70) return "D+";
		else if(digitGrade < 75) return "C";
		else if(digitGrade < 80) return "C+";
		else if(digitGrade < 85) return "B";
		else if(digitGrade < 90) return "B+";
		else if(digitGrade < 95) return "А";
		else return "А+";
	}
	  
	public double getGpa() {
		return (digitGrade / 100) * 4.0;
	}
	public String getTraditionalGrade() {
		if(digitGrade >= 0 && digitGrade < 60) return "Failure";
		else if(digitGrade < 80) return "Satisfactory";
		else if(digitGrade < 90) return "Good";
		return "Excellent";
	}

}
