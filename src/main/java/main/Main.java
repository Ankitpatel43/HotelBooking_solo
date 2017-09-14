package main;

import controllers.HotelController;
import dbAccess.AbstractJPACrudOperator;
import dbAccess.CrudOperatorFactory;
import dbAccess.ICrudOperators;
import dbAccess.JPAFilters.UserJPAFilters;
import dtos.User;

public class Main {

	public static void main(String[] args) {

		// ICrudOperators<User, UserJPAFilters> uOp =
		// CrudOperatorFactory.getUserOperator();
		// System.out.println(bOp.readOne(UserJPAFilters.FIRSTNAME, "Bob"));

		// User u = new User("Ankit", "Patel", 0);
		// bOp.create(u);

		// ICrudOperators<Hotel, HotelJPAFilters> hOp =
		// CrudOperatorFactory.getHotelOperator();
		//// //System.out.println(uOp.readOne(UserJPAFilters.FIRSTNAME,
		// "Ankit"));
		////
		////
		////
		// Hotel h = new Hotel(0,"Taj","Toronto");
		//
		//
		// Hotel h1 = new Hotel(0,"Hilton","Toronto");
		//
		// hOp.create(h);
		// hOp.create(h1);
		//// Hotel h1 = new Hotel(0,"Hilton","Toronto");
		//
		// ICrudOperators<Room, RoomJPAFilters> rOp =
		// CrudOperatorFactory.getRoomOperator();
		ICrudOperators<User, UserJPAFilters> uOp = CrudOperatorFactory.getUserOperator();
		// Room r = new Room(0, 2, 30);
		// rOp.create(r);
         User u = new User(0, "Ankit", "Patel");
         User u1 = new User(0, "Ankit", "Patel");
//		//
//		uOp.create(u);
		HotelController control = new HotelController();
		// System.out.println(control.bookRoom(u, 1, 1));
		System.out.println(control.getRoomById(2, 1));
		System.out.println(control.getById(1));
		//
		System.out.println(control.getByCity("Toronto"));
		System.out.println(control.getByHotelName("Taj"));
//		System.out.println(control.bookRoom(u, 2,2 ));
		System.out.println(control.checkUserHotelRoom(u1, 2, 1));
		// System.out.println(control.bookRoom(user, hotelId, roomId));
		AbstractJPACrudOperator.closeResources();
	}
}
