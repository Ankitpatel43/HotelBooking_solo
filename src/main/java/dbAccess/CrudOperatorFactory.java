package dbAccess;

import dbAccess.JPAFilters.HotelJPAFilters;
import dbAccess.JPAFilters.RoomJPAFilters;
import dbAccess.JPAFilters.UserJPAFilters;
import dtos.Hotel;
import dtos.Room;
import dtos.User;

public class CrudOperatorFactory {

	
	public static ICrudOperators<User, UserJPAFilters> getUserOperator(){
		return new UserJPACrudOperator();
	}
	
	public static ICrudOperators<Hotel, HotelJPAFilters> getHotelOperator(){
		return new HotelJPACrudOperator();
	}
	
	public static ICrudOperators<Room, RoomJPAFilters> getRoomOperator(){
		return new RoomJPACrudOperator();
	}
}
