/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.model.Model;

import ass.model.BaseModel.BaseModel;
import ass.model.Model.Enum.Status;

/**
 *
 * @author Admin
 */
public class Room extends BaseModel{
	private Status status;
	
	
	
	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}


	public Room(int id, String name, Status status) {
		super(id, name);
		this.status = status;
	}
	
}
