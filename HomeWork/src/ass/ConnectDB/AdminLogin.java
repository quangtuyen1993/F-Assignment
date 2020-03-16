package ass.ConnectDB;

import ass.model.Model.Admin;


public class AdminLogin {
	private static Admin admin=null;

	public static Admin getAdmin() {
		return admin;
	}

	public static void setAdmin(Admin admin) {
		AdminLogin.admin = admin;
	}
}
