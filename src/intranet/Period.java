package intranet;

public class Period {
	
    private int beginYear;

    private int endYear;

    private Semester semester;

    public int getBeginYear() {
        return this.beginYear;
    }

    public void setBeginYear(Integer beginYear) {
        this.beginYear = beginYear;
    }

    public int getEndYear() {
        return this.endYear;
    }
 
    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }
    
    public Semester getSemester() {
        return this.semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
