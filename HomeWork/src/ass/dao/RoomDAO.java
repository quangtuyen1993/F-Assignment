/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.dao;

import ass.model.Model.Room;
import ass.model.Model.Enum.Status;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class RoomDAO extends DAO {

	public RoomDAO() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static RoomDAO instance = null;

	public static RoomDAO getInstance() {
		try{
			if (instance == null) {
				instance = new RoomDAO();
			}
			return instance;
		}catch(SQLException ex){
			return null;
		}
	
	}

	public List<Room> onShowAllRoom() throws SQLException {
		List<Room> rooms = new ArrayList();
		String query = "{Call showRoom()}";
		CallableStatement stmt = connection.prepareCall(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Status status= rs.getInt(3)==0 ? Status.UNAVAILABLE : Status.AVAILABLE; 
			rooms.add(new Room(rs.getInt(1), rs.getString(2),status));
		}
		return rooms;
	}

	public List<Room> onShowRoomUnAvailable() throws SQLException {
		List<Room> rooms = new ArrayList();
		String query = "{Call showRoomUnvailable()}";
		CallableStatement stmt = connection.prepareCall(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Status status= rs.getInt(3)==0 ? Status.UNAVAILABLE : Status.AVAILABLE; 
			rooms.add(new Room(rs.getInt(1), rs.getString(2),status));
		}
		return rooms;
	}
	
	public List<Room> onShowRoomAvailable() throws SQLException {
		List<Room> rooms = new ArrayList();
		String query = "{Call showRoomAvailable()}";
		CallableStatement stmt = connection.prepareCall(query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Status status= rs.getInt(3)==0 ? Status.UNAVAILABLE : Status.AVAILABLE; 
			rooms.add(new Room(rs.getInt(1), rs.getString(2),status));
		}
		return rooms;
	}

	public List<Room> onShowRoomForUser(int _idUser) throws SQLException {
		List<Room> rooms = new ArrayList();
		String query = "{Call userRoom(?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setInt(1, _idUser);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Status status= rs.getInt(3)==0 ? Status.UNAVAILABLE : Status.AVAILABLE; 
			rooms.add(new Room(rs.getInt(1), rs.getString(2),status));
		}
		return rooms;
	}
	public List<Room> onFindRoomUserBooking(String  email) throws SQLException {
		List<Room> rooms = new ArrayList();
		String query = "{Call findRoomUserBooking(?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setString(1, email);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Status status= rs.getInt(3)==0 ? Status.UNAVAILABLE : Status.AVAILABLE; 
			rooms.add(new Room(rs.getInt(1), rs.getString(2),status));
		}
		return rooms;
	}
	public List<Room> onFindRoomByName(String name) throws SQLException{
		List<Room> rooms = new ArrayList();
		String query = "{Call findRoomByName(?)}";
		CallableStatement stmt = connection.prepareCall(query);
		stmt.setString(1, name);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Status status= rs.getInt(3)==0 ? Status.UNAVAILABLE : Status.AVAILABLE; 
			rooms.add(new Room(rs.getInt(1), rs.getString(2),status));
		}
		return rooms;
	}

}
