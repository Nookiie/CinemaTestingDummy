package uni.fmi.cinemacity.common;

import uni.fmi.cinemacity.repository.UserRepository;

public class UserService {
	private UserRepository userRepo = new UserRepository();
	private String errorMessage;
	
	public UserService() {
		
	}
	
	public boolean login(String username, String password) {
		return userRepo.existsUserByUsernameAndPassword(username, password);
	}
	
	public boolean register(String username,  String password) {
		if(username.length() > GlobalConstants.getDefaultUsernameMaxLength() 
				|| username.length() < GlobalConstants.getDefaultUsernameMinLength()
				|| password.length() < GlobalConstants.getDefaultPasswordMinLength()
				|| password.length() > GlobalConstants.getDefaultPasswordMaxLength()) {
			errorMessage = " Username and / or password does not match the criteria";
			return false;
		}
		
		if(username.isBlank() || password.isBlank()) {
			errorMessage = " Username or password is blank";
			return false;
		}
		
		try {	
				userRepo.addUser(username, password);	
			}
		catch(Exception e){
			errorMessage = "Database operation failed";
			return false;
		}
		return true;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
