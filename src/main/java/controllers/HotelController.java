package controllers;



import java.util.ArrayList;
import java.util.List;

import dbAccess.CrudOperatorFactory;
import dbAccess.ICrudOperators;
import dbAccess.JPAFilters.HotelJPAFilters;
import dbAccess.JPAFilters.RoomJPAFilters;
import dtos.Hotel;
import dtos.Room;
import dtos.User;


public class HotelController {

	
	ICrudOperators<Hotel, HotelJPAFilters> hOp = CrudOperatorFactory.getHotelOperator();
	ICrudOperators<Room, RoomJPAFilters> rOp = CrudOperatorFactory.getRoomOperator();
	//System.out.println(uOp.readOne(UserJPAFilters.FIRSTNAME, "Ankit"));
	
	//Hotel h = new Hotel(0,"Taj","Toronto");
	
	
	 public List<Hotel> getByCity(String city) {
//       
//        List<Hotel> showhotel = 
        		return hOp.read(HotelJPAFilters.HOTELCITY,city);
//        for (Hotel ht : ) {
//			
//        	if(ht.getCity().equals(city)) {
//        		showhotel.add(ht);
//        	}
//		}
        
//        return showhotel;
    }

    public List<Hotel> getByHotelName(String name) {
//       
//        
    	
    	return hOp.read(HotelJPAFilters.NAME, name);
//        List<Hotel> showhotel = new ArrayList<>();
//        for (Hotel ht : hotelDB.read()) {
//			
//        	if(ht.getName().equals(name)) {
//        		showhotel.add(ht);
//        	}
//		}
//        
//        return showhotel;
    }
//
    public Room getRoomById(int hotelId, int roomId) {
        //Hotel hotel = getById(hotelId);
        
        Hotel hotel = hOp.readOneById(hotelId);
        List<Room> room = rOp.read(RoomJPAFilters.ALL, roomId);
        if (hotel != null) {
            for (Room r : room) {
                if (rOp.readOneById(roomId).getId() == r.getId()) {
                    return rOp.readOneById(roomId);
                }
            }
        } else {
            System.out.println("Hotel is not found in the system by id = " + hotelId + "! Please, enter another hotel!");
        }
        return null;
    }

    public Hotel getById(int hotelId) {
		// TODO Auto-generated method stub
    	return hOp.readOneById(hotelId);
    	
//		for(Hotel ht : hotelDB.read()) {
//			if(ht.getHotelId() == hotelId) {
//				return ht;
//			}
//		}
//		return null;
	}
//
	public boolean bookRoom(User user, int hotelId, int roomId) {
        if (checkUserHotelRoom(user, hotelId, roomId)) {
            Room room = getRoomById(hotelId, roomId);
            if (room != null) {
                room.setUserReserved(user);
                return true;
            }
        }
        return false;
    }
//
//    public boolean cancelRoomReservation(User user, long hotelId, long roomId) {
//        if (checkUserHotelRoom(user, hotelId, roomId)) {
//            Room room = getRoomById(hotelId, roomId);
//            if (room == null) {
//                printMessage("We can't find room with id = " + roomId + " to remove reservation!");
//                return false;
//            }
//            if (user.equals(room.getUserReserved())) {
//                room.setUserReserved(null);
//                printMessage("Reservation removed from room with id = " + roomId);
//                return true;
//            } else {
//                printMessage(user + " did not reserve the room in this hotel '" + getById(hotelId).getName() + "'! Please, try with another user!");
//            }
//        }
//        return false;
//    }
//
    public boolean checkUserHotelRoom(User user, int hotelId, int roomId) {
//        if (user == null) {
//            printMessage("User is not found in the system! Please, register user in the system!");
//            return false;
//        }
//        if (!user.isUserRegistered()) {
//            printMessage("User is not registered in the system! Please, register user in the system!");
//            return false;
//        }
        Hotel hotel = hOp.readOneById(hotelId);
        if (hotel == null) {
            //printMessage("Hotel is not found in the system by id = " + hotelId + "! Please, enter another hotel!");
            return false;
        }
        if (getRoomById(hotelId, roomId) == null) {
          //  printMessage("Room is not found in hotel '" + hotel.getName() + "' by id = " + roomId + "! Please, enter another room id!");
            return false;
        }
        return true;
    }
}
