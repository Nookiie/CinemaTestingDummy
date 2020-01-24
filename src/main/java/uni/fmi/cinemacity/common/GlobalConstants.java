package uni.fmi.cinemacity.common;

public class GlobalConstants {
	// Login Result Strings
	private static final String LOGIN_SUCCESS_STRING = "Login Successful!";
	private static final String LOGIN_FAIL_STRING = "Login Failed!";
	private static final String LOGIN_FAIL_INCORRECT_DATA_STRING = LOGIN_FAIL_STRING + " Incorrect User Credentials";

	// Register Result Strings
	private static final String REGISTE_SUCCESS = "Registration Successful!";
	private static final String REGISTER_FAIL = "Registration Failed!";
	
	// Seat Reservation Result Strings
	private static final String RESERVATION_SUCCESS_STRING = "Reservation Successful!";
	private static final String RESERVATION_FAILED_STRING = "Reservation Failed!";
	private static final String RESERVATION_FAILED_NO_VACANT_SEATS_STRING = RESERVATION_FAILED_STRING + " There are no vacant seats!";
	private static final String RESERVATION_FAILED_PROJECTION_CANCELLED_STRING = RESERVATION_FAILED_STRING + "  The projection has been cancelled!";
	
	// Schedule CRUD Result Strings
	private static final String MOVIE_ADD_SUCCESSFUL_STRING = "Movie Successfully Added";
	private static final String MOVIE_REMOVE_SUCCESSFUL_STRING = "Movie Successfully Removed!";
	private static final String MOVIE_UPDATE_SUCCESSUL_STRING = "Movie Successfully Updated";
	private static final String MOVIE_CRUD_FAIL_STRING = "Error, movie could not be added";
	
	// Misc Projections and Schedules Values
	private static final int DEFAULT_MAX_SEATS = 70;
	
	// Registration attribute values
	private static final int DEFAULT_USERNAME_MAX_LENGTH = 50;
	private static final int DEFAULT_USERNAME_MIN_LENGTH = 3;
	private static final int DEFAULT_PASSWORD_MAX_LENGTH = 32;
	private static final int DEFAULT_PASSWORD_MIN_LENGTH = 8;

	public static int getDefaultUsernameMaxLength() {
		return DEFAULT_USERNAME_MAX_LENGTH;
	}

	public static int getDefaultUsernameMinLength() {
		return DEFAULT_USERNAME_MIN_LENGTH;
	}

	public static int getDefaultPasswordMaxLength() {
		return DEFAULT_PASSWORD_MAX_LENGTH;
	}

	public static int getDefaultPasswordMinLength() {
		return DEFAULT_PASSWORD_MIN_LENGTH;
	}

	public static String getLoginSuccessString() {
		return LOGIN_SUCCESS_STRING;
	}

	public static String getLoginFailString() {
		return LOGIN_FAIL_STRING;
	}

	public static String getLoginFailIncorrectDataString() {
		return LOGIN_FAIL_INCORRECT_DATA_STRING;
	}

	public static String getRegisterSuccessString() {
		return REGISTE_SUCCESS;
	}

	public static String getRegisterFailString() {
		return REGISTER_FAIL;
	}

	public static String getReservationSuccessString() {
		return RESERVATION_SUCCESS_STRING;
	}

	public static String getReservationFailedString() {
		return RESERVATION_FAILED_STRING;
	}

	public static String getReservationFailedNoVacantSeatsString() {
		return RESERVATION_FAILED_NO_VACANT_SEATS_STRING;
	}

	public static String getReservationFailedProjectionCancelledString() {
		return RESERVATION_FAILED_PROJECTION_CANCELLED_STRING;
	}

	public static String getMovieAddSuccessfulString() {
		return MOVIE_ADD_SUCCESSFUL_STRING;
	}

	public static String getMovieRemoveSuccessfulString() {
		return MOVIE_REMOVE_SUCCESSFUL_STRING;
	}

	public static String getMovieUpdateSuccessulString() {
		return MOVIE_UPDATE_SUCCESSUL_STRING;
	}

	public static String getMovieCrudFailString() {
		return MOVIE_CRUD_FAIL_STRING;
	}

	public static int getDefaultMaxSeats() {
		return DEFAULT_MAX_SEATS;
	}
}
