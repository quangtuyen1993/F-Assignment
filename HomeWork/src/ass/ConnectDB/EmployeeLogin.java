package ass.ConnectDB;

import ass.model.Model.Employee;

public class EmployeeLogin {
	private static Employee employee=null;

	public static Employee getEmployee() {
		return employee;
	}

	public static void setEmployee(Employee employee) {
		EmployeeLogin.employee = employee;
	}
	
}
