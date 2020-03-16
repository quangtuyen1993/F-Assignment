/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.dao;

import ass.ConnectDB.ConnectDB;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Admin
 * @param <T>
 */
public abstract  class DAO<T extends DAO>{
	protected Connection connection;
	public DAO() throws SQLException {connection=ConnectDB.getInstance();}
}
