package ass.ConnectDB;

import ass.model.Model.Customer;

public class UserLogin {
	private static Customer customer =null;

	public static Customer getCustomer() {
		return customer;
	}

	public static void setCustomer(Customer customer) {
		UserLogin.customer = customer;
	}
	
}
