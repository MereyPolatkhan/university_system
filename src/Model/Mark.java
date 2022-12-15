package Model;


public class Mark {
	private Grade firstAtt;
	private Grade secondAtt;
	private Grade finalAtt;
	
	public Mark() {};
	
	public Mark(Grade firstAtt, Grade secondAtt, Grade finalAtt) {
		this.setFirstAtt(firstAtt);
		this.setSecondAtt(secondAtt);
		this.setFinalAtt(finalAtt);
	}

	public Grade getFirstAtt() {
		return firstAtt;
	}

	public void setFirstAtt(Grade firstAtt) {
		this.firstAtt = firstAtt;
	}

	public Grade getSecondAtt() {
		return secondAtt;
	}

	public void setSecondAtt(Grade secondAtt) {
		this.secondAtt = secondAtt;
	}

	public Grade getFinalAtt() {
		return finalAtt;
	}

	public void setFinalAtt(Grade finalAtt) {
		this.finalAtt = finalAtt;
	}

	public Grade getTotal() {
		Grade total = new Grade();
		total.digitGrade = firstAtt.digitGrade + secondAtt.digitGrade + finalAtt.digitGrade;
		total.datePut = finalAtt.datePut;
		return total;
	}

	
	

}
