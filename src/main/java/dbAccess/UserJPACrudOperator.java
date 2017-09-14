package dbAccess;

import dbAccess.JPAFilters.UserJPAFilters;

import dtos.User;

public class UserJPACrudOperator extends AbstractJPACrudOperator<User, UserJPAFilters>{

	
	public UserJPACrudOperator() {
		super(User.class);
	}
}
