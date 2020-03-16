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
public class Admin extends BaseUserModel {
	public Role role=Role.ADMIN;
	public Admin(int id,String email, String password,  String name) {
		super(email, password, id, name);
	}
	public Admin(String email, String password,  String name) {
		super(email, password, name);
	}
}
