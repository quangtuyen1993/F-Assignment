/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.Controller;


import java.sql.SQLException;

import ass.model.BaseModel.BaseModel;

/**
 *
 * @author Admin
 * @param <T>
 */
public interface UserControllers<T extends BaseModel> {
	int login(String email,String password) throws SQLException;
	int register(T t)throws SQLException;
}
