/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.menu;

import ass.Ass;

import ass.ConnectDB.UserLogin;
import ass.dao.BookingDAO;
import ass.dao.CustomerDAO;
import ass.dao.RoomDAO;
import static ass.menu.Util.inputInt;
import static ass.menu.Util.inputString;
import ass.model.Model.Customer;
import ass.model.Model.Enum.Status;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class CustomerMenu {

	private static Scanner scan;

			private static final RoomDAO roomDao = RoomDAO.getInstance();
			private static final BookingDAO bookingDAO = BookingDAO.getInstance();
			private static final CustomerDAO cDao = CustomerDAO.getInstance();

	

	public static void menuCustomer() {
		for(;;){
			try{
				scan = new Scanner(System.in);
				System.out.println("==========================");
				System.out.println("1\tLogin");
				System.out.println("2\tRegister");
				System.out.println("==========================");
				int input = scan.nextInt();

				switch (input) {
					case 1:
						login();
						break;
					case 2:
						register();
						break;
					default:
						new RuntimeException("choose again");
						break; 
				}
			}catch(RuntimeException ex){
				System.err.println(ex.getMessage());
			}catch(SQLException ex){
				System.err.println(ex.getMessage());
			}
			
		}
		

	}

	private static void register() throws SQLException {
		String email = inputString("Please Enter your email");
		String password = inputString("Please Enter your password");
		String name=inputString("Please Enter your full name");
		cDao.register(new Customer(email, password, name));
		System.out.println("Success");
	}

	private static void login() throws SQLException {
		scan = new Scanner(System.in);
		System.out.println("==========================");
		String email = inputString("1\tEnter Email");
		String password = inputString("2\tEnter Password");
		System.out.println("==========================");
		cDao.login(email, password);
		showMenuBooking();
	}

	public static void showMenuBooking() throws SQLException {
		Exit:for(;;){
			System.out.println("+==========================");
			System.out.println("+1. Booking Room");
			System.out.println("+2. Exit");
			System.out.println("+==========================");
			scan = new Scanner(System.in);
			switch (scan.nextInt()) {
				case 1:
					showRoomAvailable();
					break;
				case 2:
					break Exit;
			}
		}
		
	}

	private static void showRoomAvailable() {
		try {
			roomDao.onShowRoomAvailable().forEach(room -> {
				String status = room.getStatus()==Status.AVAILABLE ? "Available": "Unavailable";
				System.out.printf("%-25.30s => %-25.30s  %-25.30sStatus \n", room.getId(), room.getName(),status);
			});
			int idRoom = inputInt("Please chose room");
			bookingDAO.onCheckIn(idRoom, UserLogin.getCustomer().getId());
			System.out.println("Success");

		} catch (SQLIntegrityConstraintViolationException ex) {
			System.out.println("input don't match");
		} catch (SQLException ex) {
			Logger.getLogger(Ass.class.getName()).log(Level.SEVERE, null, ex);
		}
	}



}
