package uni.fmi.login.ui;

import uni.fmi.cinemacity.common.GlobalConstants;
import uni.fmi.cinemacity.common.UserService;

public class RegisterForm {
	private UserService userService = new UserService();
	
	private String username, password, message;
	public RegisterForm() {
		
	}
	
	public void addUsername(String username) {
		this.username = username;
	}
	
	public void addPassword(String password) {
		this.password  = password;
	}
	
	public void clickRegisterButton() {
		if(userService.register(username, password)) {
				message = GlobalConstants.getRegisterSuccessString();	
		}
		else {
			message = GlobalConstants.getRegisterFailString() + userService.getErrorMessage();
		}
	}
	
	public String getMessage() {
		return message;
	}
}
