package intranet;

public class Test {
	public static void main(String[] args) {
		Teacher t = new Teacher();
		Teacher t2 = new Teacher();
		Teacher t3= new Teacher();
		Teacher t4 = new Teacher();
		
	
		for (Teacher tt: Teacher.allTeachers) {
			System.out.println(tt);
		}
	}
}
