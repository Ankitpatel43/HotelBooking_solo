package dbAccess;

public interface JPAFilters extends Filters{

	
	String getParamName();

	public enum UserJPAFilters implements JPAFilters {
		FIRSTNAME("User.byFirstName", "firstName"), LASTNAME("User.byLastName", "lastName"), ALL("User.all",
				null), LOGIN("User.login", "uname:pw");

		private final String queryName, paramName;

		private UserJPAFilters(String queryName, String paramName) {
			this.queryName = queryName;
			this.paramName = paramName;
		}

		@Override
		public String getFilter() {
			return this.queryName;
		}

		@Override
		public String getParamName() {
			return this.paramName;
		}

	}
	
	
	public enum HotelJPAFilters implements JPAFilters {
		NAME("Hotel.byHotelName", "hotelName"), HOTELCITY("Hotel.byCity",
				"hotelCity"),  ALL("Hotel.all", null);

		private final String queryName, paramName;

		private HotelJPAFilters(String queryName, String paramName) {
			this.queryName = queryName;
			this.paramName = paramName;
		}

		@Override
		public String getFilter() {
			return this.queryName;
		}

		@Override
		public String getParamName() {
			return this.paramName;
		}
	}
	
	public enum RoomJPAFilters implements JPAFilters {
		NAME("Room.byPersons", "persons"), PRICE("Room.byPrice",
				"price"),USERRESERVED("Room.byuserReserved", "userReserved"), ALL("Room.all", null);

		private final String queryName, paramName;

		private RoomJPAFilters(String queryName, String paramName) {
			this.queryName = queryName;
			this.paramName = paramName;
		}

		@Override
		public String getFilter() {
			return this.queryName;
		}

		@Override
		public String getParamName() {
			return this.paramName;
		}
	}
}
