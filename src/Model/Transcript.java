package Model;

import java.util.Vector;

public class Transcript {
<<<<<<< HEAD:src/Model/Transcript.java
    
    /**
    * @generated
    */
    public Vector<Journal> journals;
    
    
    /**
    * @generated
    */
    private Database database;
    
    /**
    * @generated
    */
    private Student student;
    
    /**
    * @generated
    */
    private Journal journal;
    
    
=======
	
	public int numberOfFailedCourses;
	public Vector<Journal> journals;
	
	public Transcript(){
		numberOfFailedCourses = 0;
	}
	
	public Transcript(Vector<Journal> journals){
		this();
		this.journals = journals;
	}
	
	{
	if(numberOfFailedCourses >= 3)
		leaveUniversity();
	}
>>>>>>> fa50f5481524df74d05be5f52cd93c40dc96e12d:src/intranet/Transcript.java

	private void leaveUniversity() {
		//removeUser?
	}
}
