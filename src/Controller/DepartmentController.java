package Controller;

import java.io.IOException;

import Model.Department;

public class DepartmentController {
	public static Department createDepartment() {
		System.out.println("Please prodive department name: ");			
		try {
			String depName = (ManagerController.br.readLine()).trim();
			for (Department d: Department.depatments) {
				if (d.name.equals(depName)) { 
					return d;
				}
			}
		} catch (IOException e) {
			System.out.println("Provided incorrect data");
			e.printStackTrace();
		}
		return new Department();
	}
	
	
}
