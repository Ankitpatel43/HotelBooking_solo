package dtos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_User")
@NamedQueries({ @NamedQuery(name = "User.byFirstName", query = "select b from User b where b.firstName=:firstName"),
		@NamedQuery(name = "User.byLastName", query = "select b from User b where b.lastName=:lastName"),
		@NamedQuery(name = "User.all", query = "select b from User b") })

public class User implements IEntity {

	@Id
	@GeneratedValue(generator = "hib_userid_seq")
	@SequenceGenerator(name = "hib_userid_seq", sequenceName = "seq_user_id", initialValue = 1, allocationSize = 1)
	private int Id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	// @Column(name = "user_registered")
	// private boolean userRegistered;

	public User(int id,String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		Id = id;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "User [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
