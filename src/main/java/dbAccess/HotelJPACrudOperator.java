package dbAccess;

import dbAccess.JPAFilters.HotelJPAFilters;

import dtos.Hotel;


public class HotelJPACrudOperator  extends AbstractJPACrudOperator<Hotel, HotelJPAFilters>{

	
	public HotelJPACrudOperator() {
		super(Hotel.class);
	}
}
