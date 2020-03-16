package ass.ConnectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
	private static Connection instance =null;
	public static Connection getInstance() throws SQLException{
		if(instance==null){
			instance = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/hotel", "root", "admin");
		}
		return instance;
	}
}
