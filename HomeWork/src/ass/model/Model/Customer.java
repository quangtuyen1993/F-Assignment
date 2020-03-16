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
public class Customer extends BaseUserModel{
	
	public Role role=Role.CUSTOMER;

	public Customer( int id, String email, String password,String name) {
		super(email, password, id, name);
	}

	public Customer(String email, String password, String name) {
		super(email, password, name);
	}

	

	



	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
