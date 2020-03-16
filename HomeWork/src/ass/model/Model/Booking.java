/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.model.Model;

/**
 *
 * @author Admin
 */
public class Booking {
	private String id;
	private String idRoom;
	private String idCustomer;

	public Booking(String id, String idRoom, String idCustomer) {
		this.id = id;
		this.idRoom = idRoom;
		this.idCustomer = idCustomer;
	}

	public Booking(String idRoom, String idCustomer) {
		this.idRoom = idRoom;
		this.idCustomer = idCustomer;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdRoom() {
		return idRoom;
	}

	public void setIdRoom(String idRoom) {
		this.idRoom = idRoom;
	}

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}
	
	
	
	
	
}
