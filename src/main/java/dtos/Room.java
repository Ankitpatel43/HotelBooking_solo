package dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "tbl_Room")
@NamedQueries({ @NamedQuery(name = "Room.byPersons", query = "select b from Room b where b.persons=:persons"),
		@NamedQuery(name = "Room.byPrice", query = "select b from Room b where b.price=:price"),
		@NamedQuery(name = "Room.all", query = "select b from Room b"),
        @NamedQuery(name = "Room.byUser", query = "Select b from Room b where b.userReserved = :userReserved")})
public class Room implements IEntity {

	
	@Id
	@GeneratedValue(generator = "hib_roomid_seq")
	@SequenceGenerator(name = "hib_roomid_seq", sequenceName = "seq_room_id", initialValue = 1, allocationSize = 1)
	private int Id;
	@Column(name = "persons")
	private int persons;
	@Column(name = "price")
    private double price;
	@OneToOne
    private User userReserved;
   
    
    
	public Room(int id, int persons, double price ) {
		super();
		this.persons = persons;
		this.price = price;
		//this.userReserved = userReserved;
		Id = id;
	}
	
	
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getPersons() {
		return persons;
	}
	public void setPersons(int persons) {
		this.persons = persons;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public User getUserReserved() {
		return userReserved;
	}
	public void setUserReserved(User userReserved) {
		this.userReserved = userReserved;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}


	@Override
	public String toString() {
		return "Room [persons=" + persons + ", price=" + price + ", userReserved=" + userReserved + ", Id=" + Id + "]";
	}
	
	
}
