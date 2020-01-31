package uni.fmi.ui;

import uni.fmi.cinemacity.common.GlobalConstants;
import uni.fmi.cinemacity.common.UserService;

public class LoginForm {
	private UserService userService = new UserService();
	
	private String username, password, message;

	public void addUsername(String username) {
		this.username = username;
	}
	
	public void addPassword(String password) {
		this.password = password;
	}

	public void clickLoginButton() {
		if(userService.login(username, password)) {
			message = GlobalConstants.getLoginSuccessString();
		}
		else {
			message = GlobalConstants.getLoginFailString();
		}
	}
	
	public boolean isLoggedIn() {
		if(userService.login(username, password)) {
			return true;
		}
		else {
			return false;
		}
	}

	public String getMessage() {
		return message;
	}
}
