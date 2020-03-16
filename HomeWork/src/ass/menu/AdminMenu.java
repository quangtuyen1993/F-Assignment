package ass.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import ass.dao.AdminDAO;
import ass.dao.CustomerDAO;
import ass.dao.EmployeeDAO;
import ass.model.Model.Admin;
import ass.model.Model.Customer;
import ass.model.Model.Employee;
import ass.model.Model.Enum.Role;

public class AdminMenu {
	private static AdminDAO adminDAO = AdminDAO.getInstance();
	private static CustomerDAO customerDAO = CustomerDAO.getInstance();
	private static EmployeeDAO employeeDAO = EmployeeDAO.getInstance();

	public static void menuAdmin() {
			String email = Util.inputString("Please Enter email");
			String password = Util.inputString("Please enter password");
			adminDAO.login(email, password);
			showMenuAdmin();
	}

	public static void showMenuAdmin() {
		MENU: for (;;) {
			try {
				System.out.println("1. Create new Admin");
				System.out.println("2. Change role");
				System.out.println("3. Exit");
				int input = Util.inputInt("Choose input ");
				switch (input) {
				case 1:
					createNewAdmin();
					break;
				case 2:
					showMenuUser();
					break;
				case 3:
					break MENU;
				default:
					break;
				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}

		}

	}

	public static void createNewAdmin() throws SQLException {
		String email = Util.inputString("Please enter email");
		String password = Util.inputString("Please enter password");
		String name = Util.inputString("Please enter name");
		adminDAO.register(new Admin(email, password, name));
	}

	public static void showMenuUser() throws SQLException {
		System.out.println("1. Change Customer");
		System.out.println("2. Change Employee");
		int input = Util.inputInt("Please choose");
		switch (input) {
		case 1:
			showMenuCustomer();
			break;
		case 2:
			showMenuEmployee();
			break;
		default:
			break;
		}
	}

	public static void showMenuCustomer() throws SQLException {
		List<Customer> customers = customerDAO.onFetchList();
		Util.getDilivider(30, 3);
		System.out.printf("|%-30.25s |%-30.25s |%-30.25s |\n","Id","Email","Full Name");
		Util.getDilivider(30,3);
		customers.forEach(cus -> {
			System.out.printf("|%-30.25s |%-30.25s |%-30.25s |\n",cus.getId(),cus.getEmail(),cus.getName());
		});
		Util.getDilivider(30,3);
		System.out.println("Enter 0 to comeback");
		int input = Util.inputInt("Please chose id you want change");
		if (!Util.checkInputInList(customers, input))
			throw new RuntimeException("Input incorrect");
		if(input==0) throw new RuntimeException("Comeback");
		adminDAO.changeRole(input, Role.EMPLOYEE);
	}

	public static void showMenuEmployee() throws SQLException {
		List<Employee> emps = employeeDAO.onFetchList();
		String[] title=new String[]{"id","email","fullName"};
		Util.getDilivider(30,title);
		//System.out.printf("|%-30.25s |%-30.25s |%-30.25s |\n","Id","Email","Full Name");
		//Util.getDilivider(30, 3);
		emps.forEach(emp -> {
			System.out.printf("|%-30.25s |%-30.25s |%-30.25s |\n",emp.getId(),emp.getEmail(),emp.getName());
		});
		//Util.getDilivider(30, 3);
		System.out.println("Enter 0 to comeback");
		int input = Util.inputInt("Please chose id you want change");
		if (!Util.checkInputInList(emps, input))
			throw new RuntimeException("Input incorrect");
		if(input==0) throw new RuntimeException("Comeback");
		adminDAO.changeRole(input, Role.CUSTOMER);
	}
}
