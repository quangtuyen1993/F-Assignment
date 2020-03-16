/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ass.menu;

import ass.dao.BookingDAO;
import ass.dao.CustomerDAO;
import ass.dao.EmployeeDAO;
import ass.dao.RoomDAO;
import ass.model.Model.Customer;
import ass.model.Model.Room;
import ass.model.Model.Enum.Status;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 *
 * @author Admin
 */
public class EmployeeMenu {

	private static EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
	private static RoomDAO roomDAO=RoomDAO.getInstance();
	private static BookingDAO bookingDAO=BookingDAO.getInstance();
	private static CustomerDAO customerDAO=CustomerDAO.getInstance();

	public static void showMenuEmployee() {
		try {
			login();
		} catch (Exception ex) {

		}

	}

	private static void login(){
		String email = Util.inputString("Enter email");
		String password = Util.inputString("Enter password");
		try {
			employeeDAO.login(email, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Menu:for(;;){
			try {
				System.out.println("\n1. View All Room and State");
				System.out.println("2. Find User by email and checkOut");
				System.out.println("3. Find Room by name and checkOut");
				System.out.println("4. Exit");
				int input =Util.inputInt("Please choose...");
				switch(input){
				case 1:
				
						showViewAllRoom();
				
					break;
				case 2:
					findRoomUserBooking();
					break;
				case 3:
					findRoomByNameAndCheckOut();
					break;
				case 4:
					break Menu;
				
				default:
					System.out.println("input incorrect");
				}
			} catch (SQLException e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
			}catch(RuntimeException ex){
				System.err.print(ex.getMessage());
			}
				
		}
	
	

	}
	private static void showViewAllRoom() throws SQLException{
		System.out.println("Enter 0 to comback");
		Util.getDilivider(30, 3);
		System.out.printf("| %-30.25s | %-30.25s | %-30.25s |\n","ID Room","Name","Status");
		Util.getDilivider(30, 3);
		roomDAO.onShowAllRoom().forEach(room->{
			String status = room.getStatus()==Status.AVAILABLE ? "Available": "Unavailable";
			System.out.printf("| %-30.25s | %-30.25s | %-30.25s |\n", room.getId(), room.getName(),status);
		});
		Util.getDilivider(30, 3);
		int input = Util.inputInt("Enter id for changing status");
		bookingDAO.onCheckOut(input);
			
	}
	public static void findRoomUserBooking() throws SQLException{
		String email=Util.inputString("please enter email customer");
		
		Customer customer =customerDAO.findByEmailCustomer(email);
		Util.getDilivider(30, 3);
		System.out.printf("| %-30.25s | %-30.25s | %-30.25s |\n","ID Cus","Name","Email");
		Util.getDilivider(30, 3);
		System.out.printf("| %-30.25s | %-30.25s | %-30.25s |\n",customer.getId(), customer.getName(),customer.getEmail());
		Util.getDilivider(30, 3);
		
		
		List<Room>rooms=roomDAO.onFindRoomUserBooking(email);
		if(rooms.size()<1) throw new RuntimeException("Room don't exists");
		rooms.forEach(room->{
			System.out.println("Room id: "+room.getId()+" Room name: "+room.getName());
		});
		int idRoom=Util.inputInt("please enter idRoom check out");
		if(idRoom==0) throw new RuntimeException("Comback");
		if(!Util.checkInputInList(roomDAO.onFindRoomUserBooking(email), idRoom)) 
			throw new RuntimeException("input not match"); 
		bookingDAO.onCheckOut(idRoom);
		
	}
	public static void findRoomByNameAndCheckOut() throws SQLException{
		String name=Util.inputString("Please enter name room");
		List<Room> list= roomDAO.onShowAllRoom();
		List<Room> listFilter= list
				.stream()
				.filter(room->room.getName().toLowerCase().contains(name.toLowerCase()))
				.collect(Collectors.toList());
		listFilter.forEach(room->{
			String status=room.getStatus()==Status.AVAILABLE ? "Available":"Unavailable";
			System.out.println("RoomId: "+room.getId()+"\tRoom Name: "+room.getName()+"\tRoom Status: "+status);
		});
		System.out.println("Enter 0 to comback");
		int idRoom=Util.inputInt("please enter idRoom check out");
		
		
		if(!Util.checkInputInList(list, idRoom)) 
			throw new RuntimeException("input not match"); 
		if(idRoom==0) throw new RuntimeException("Comback");
		
		
		bookingDAO.onCheckOut(idRoom);
		
	}
	
	
}
