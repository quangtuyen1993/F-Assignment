package ass.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import ass.ConnectDB.AdminLogin;
import ass.ConnectDB.UserLogin;
import ass.Controller.UserControllers;
import ass.model.Model.Admin;
import ass.model.Model.Customer;
import ass.model.Model.Enum.Role;

public class AdminDAO extends DAO implements UserControllers<Admin> {

	private static AdminDAO instance=null;
	
	
	
	public static AdminDAO getInstance() {
		if(instance==null){
			try {
				instance=new AdminDAO();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return instance;
	}



	public AdminDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int login(String email, String password){
		String query = "{Call loginAdmin(?,?)}";
		CallableStatement stmt;
		try {
			stmt = connection.prepareCall(query);
			stmt.setString(1, email);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			Admin admin = null;
			while (rs.first()) {
				admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				AdminLogin.setAdmin(admin);
				return 1;
			}
			throw new RuntimeException("email or password incorrect");
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		}
	}

	@Override
	public int register(Admin t) throws SQLException {
		String query = "{Call createAdmin(?,?,?)}";
		CallableStatement stmt;
		try {
			stmt = connection.prepareCall(query);
			stmt.setString(1, t.getEmail());
			stmt.setString(2, t.getPassword());
			stmt.setString(3, t.getName());
			int result = stmt.executeUpdate();
			return result;
			//throw new RuntimeException("email or password incorrect");
		} catch (SQLException ex) {
			Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
			return 0;
		}
		//return 1;
	}
	public int changeRole(int id,Role role){
		try{
			int r = role == Role.CUSTOMER ? 0 : 1;
			String query ="{Call changeRole(?,?)}";
			CallableStatement stmt=connection.prepareCall(query);
			stmt.setInt(1, id);
			stmt.setInt(2, r);
			int rs=stmt.executeUpdate();
			return rs;
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
			return 0;
		}
	
		
		
		
	}
	

}
