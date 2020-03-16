/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass;

import ass.menu.AdminMenu;
import ass.menu.CustomerMenu;
import ass.menu.EmployeeMenu;
import ass.menu.Util;

/**
 *
 * @author Admin
 */
public class Ass {

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String[] args) {
		// TODO code application logic here
		try {
			// CustomerMenu.menuCustomer();
			// EmployeeMenu.showMenuEmployee();
			mainMenu();
		} catch (Exception ex) {
			System.out.println("error " + ex.getMessage() + ex.getClass());
		}

	}

	public static void mainMenu() {
		for (;;) {
			try {
				System.out.println("1. Login Customer");
				System.out.println("2. Login Employee");
				System.out.println("3. Login Admin");
				int input = Util.inputInt("Choose");
				switch (input) {
				case 1:
					CustomerMenu.menuCustomer();
					break;
				case 2:
					EmployeeMenu.showMenuEmployee();
					break;
				case 3:
					AdminMenu.menuAdmin();
					break;
				case 4:
					System.out.println("Exit");
					System.exit(0);
					break;
				default:
					throw new RuntimeException("input incorrect, please choose againt");

				}
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
	}

}
