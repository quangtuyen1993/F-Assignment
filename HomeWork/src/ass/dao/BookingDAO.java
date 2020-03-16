/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class BookingDAO extends DAO {

	public BookingDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static BookingDAO instance = null;

	public static BookingDAO getInstance() {
		try {
			if (instance == null) {
				instance = new BookingDAO();
			}
		} catch (SQLException ex) {

		}

		return instance;
	}

	public int onCheckIn(int idRoom, int idCusomter) throws SQLException {
		String query = "{CALL booking(?,?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setInt(1, idCusomter);
		stmt.setInt(2, idRoom);
		int check = stmt.executeUpdate();
		return check;
	}

	public int onCheckOut(int idRoom) throws SQLException {
		String query = "{CALL checkOut(?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setInt(1, idRoom);
		int check = stmt.executeUpdate();
		return check;
	}

}
