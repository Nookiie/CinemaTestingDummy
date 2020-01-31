package uni.fmi.ui;

public class Homepage {

	private boolean getLogggedInStatus = false;

	public LoginForm clickLoginButton() {
		return new LoginForm();
	}
	
	public RegisterForm clickCreateAccountButton() {
		return new RegisterForm();
	}
	
	public ReservationForm clickCreateReservationButton() {
		return new ReservationForm();
	}
	
	public ProjectionForm clickChooseProjectionButton() {
		return new ProjectionForm();
	}

	public boolean isGetLoggedInStatus() {
		return getLogggedInStatus;
	}

	public void setGetLoggedInStatus(boolean getLogggedInStatus) {
		this.getLogggedInStatus = getLogggedInStatus;
	}
}
