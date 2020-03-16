/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.model.Model.Enum;

/**
 *
 * @author Admin
 */
public enum Role {
	ADMIN(2),
	EMPLOYEE(1),
	CUSTOMER(0);
	private int value;
	Role(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

}
