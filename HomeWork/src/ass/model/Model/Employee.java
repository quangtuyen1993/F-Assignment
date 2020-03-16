/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.model.Model;

import ass.model.BaseModel.BaseUserModel;
import ass.model.Model.Enum.Role;

/**
 *
 * @author Admin
 */
public class Employee extends BaseUserModel {
	public Role role = Role.EMPLOYEE;

	/**
	 *
	 * @param email
	 * @param password
	 * @param id
	 * @param name
	 */

	public Employee(int id, String email, String password,String name ) {
		super(email, password, id, name);
	}

	public Employee(String email, String password, String name) {
		super(email, password, name);
	}

	public Employee(String email, String password) {
		super(email, password);
	}

}
