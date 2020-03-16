/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.model.BaseModel;

/**
 *
 * @author Admin
 */
public abstract class BaseUserModel extends BaseModel{
	
	protected String email;
	protected String password;
	
	

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

	public BaseUserModel(String email, String password, int id, String name) {
		super(id, name);
		this.email = email;
		this.password = password;
	}

	public BaseUserModel(String email, String password, String name) {
		super(name);
		this.email = email;
		this.password = password;
	}

	public BaseUserModel(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	
}
