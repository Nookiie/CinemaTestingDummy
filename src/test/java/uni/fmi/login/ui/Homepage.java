package uni.fmi.login.ui;

public class Homepage {

	private boolean getLogggedInStatus = false;

	public LoginForm clickLoginButton() {
		return new LoginForm();
	}

	public boolean isGetLoggedInStatus() {
		return getLogggedInStatus;
	}

	public void setGetLoggedInStatus(boolean getLogggedInStatus) {
		this.getLogggedInStatus = getLogggedInStatus;
	}

	public RegisterForm clickCreateAccountButton() {
		return new RegisterForm();
	}
}
