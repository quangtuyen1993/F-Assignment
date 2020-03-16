/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.dao;

import ass.ConnectDB.ConnectDB;
import ass.ConnectDB.UserLogin;
import ass.model.Model.Customer;
import ass.model.Model.Room;
import ass.model.Model.Enum.Role;
import ass.model.Model.Enum.Status;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ass.Controller.UserControllers;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class CustomerDAO extends DAO implements UserControllers<Customer> {
	public CustomerDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static CustomerDAO instance = null;

	public static CustomerDAO getInstance() {
		try {
			if (instance == null) {
				instance = new CustomerDAO();
			}
		} catch (SQLException sql) {

		}

		return instance;
	}

	@Override
	public int login(String email, String password) {
		String query = "{Call loginUser(?,?)}";
		CallableStatement stmt;
		try {
			stmt = connection.prepareCall(query);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			Customer customer = null;
			while (rs.first()) {
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				UserLogin.setCustomer(customer);
				return 1;
			}
			throw new RuntimeException("email or password incorrect");
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		}
	}

	@Override
	public int register(Customer t) throws SQLException {
		String query = "{Call RegisterUser(?,?,?,?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setString(1, t.getEmail());
		stmt.setString(2, t.getPassword());
		stmt.setString(3, t.getName());
		stmt.setInt(4, t.role.getValue());
		int result = stmt.executeUpdate();
		System.out.println(String.valueOf(result) + "");
		return 1;
	}

	public Customer findByEmailCustomer(String email){
		String query = "{Call findCustomerByEmail(?)}";
		CallableStatement stmt;
		try {
			stmt = connection.prepareCall(query);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			Customer customer = null;
			while (rs.first()) {
				customer = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				UserLogin.setCustomer(customer);
				return customer;
			}
			throw new RuntimeException("email or password incorrect");
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}

	public List<Customer> onFetchList() throws SQLException{
		List<Customer> customers = new ArrayList();
		String query = "{Call onFetchUser(?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setInt(1, Role.CUSTOMER.getValue());
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Customer customer=new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			customers.add(customer);
		}
		return customers;
	}
}
