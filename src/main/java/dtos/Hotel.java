package dtos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_Hotel")
@NamedQueries({ @NamedQuery(name = "Hotel.byHotelName", query = "select b from Hotel b where b.hotelName=:hotelName"),
		@NamedQuery(name = "Hotel.byCity", query = "select b from Hotel b where b.hotelCity=:hotelCity"),
		@NamedQuery(name = "Hotel.all", query = "select b from Hotel b") })
public class Hotel implements IEntity{

	
	
		@Id
		@GeneratedValue(generator = "hib_hotelid_seq")
		@SequenceGenerator(name = "hib_hotelid_seq", sequenceName = "seq_hotel_id", initialValue = 1, allocationSize = 1)
	    private int Id;
		@Column(name = "hotel_name")
	    private String hotelName;
		@Column(name = "hotel_city")
	    private String hotelCity;
	    
	   
		@OneToMany
	    List<Room> hotelRooms;

		public Hotel(int Id,String hotelName, String hotelCity ) {
			super();
			this.hotelName = hotelName;
			this.hotelCity = hotelCity;
			this.Id = Id;
		}

		public Hotel() {
			super();
			
			hotelRooms = new ArrayList<>();
			// TODO Auto-generated constructor stub
		}

		public String getHotelName() {
			return hotelName;
		}

		public void setHotelName(String hotelName) {
			this.hotelName = hotelName;
		}

		public String getHotelCity() {
			return hotelCity;
		}

		public void setHotelCity(String hotelCity) {
			this.hotelCity = hotelCity;
		}

		

		public List<Room> getHotelRooms() {
			return hotelRooms;
		}

		public void setHotelRooms(List<Room> hotelRooms) {
			this.hotelRooms = hotelRooms;
		}

		public int getId() {
			return Id;
		}

		public void setId(int id) {
			Id = id;
		}

		@Override
		public String toString() {
			return "Hotel [hotelName=" + hotelName + ", hotelCity=" + hotelCity + ", Id=" + Id + ", hotelRooms="
					+ hotelRooms + "]";
		}

	
		
		
	    
	    
}
