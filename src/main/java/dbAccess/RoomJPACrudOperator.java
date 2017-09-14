package dbAccess;


import dbAccess.JPAFilters.RoomJPAFilters;

import dtos.Room;


public class RoomJPACrudOperator extends AbstractJPACrudOperator<Room, RoomJPAFilters> {

	public RoomJPACrudOperator() {
		super(Room.class);
	}
}
