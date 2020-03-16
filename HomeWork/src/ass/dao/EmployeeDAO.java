/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.dao;

import ass.ConnectDB.EmployeeLogin;
import ass.Controller.UserControllers;
import ass.model.Model.Customer;
import ass.model.Model.Employee;
import ass.model.Model.Enum.Role;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TuyenNQ2
 */
public class EmployeeDAO extends DAO implements UserControllers<Employee> {

	public EmployeeDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static EmployeeDAO instance = null;

	public static EmployeeDAO getInstance() {
		try {
			if (instance == null) {
				instance = new EmployeeDAO();
			}
		} catch (SQLException ex) {

		}

		return instance;
	}

	@Override
	public int login(String email, String password) throws SQLException {
		String query = "{Call loginEmployee(?,?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setString(1, email);
		stmt.setString(2, password);
		ResultSet rs = stmt.executeQuery();
		while (rs.first()) {
			Employee employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			EmployeeLogin.setEmployee(employee);
			return 1;
		}
		throw new RuntimeException("email or passord incorrect");
		
	}

	@Override
	public int register(Employee t) throws SQLException {
		throw new UnsupportedOperationException("Not supported yet."); 
	}
	public List<Employee> onFetchList() throws SQLException{
		List<Employee> employees = new ArrayList();
		String query = "{Call onFetchUser(?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setInt(1, Role.EMPLOYEE.getValue());
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Employee employee=new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			employees.add(employee);
		}
		return employees;
	}

}
