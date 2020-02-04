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
			if(username == null || username.equals("")) {
				errorMessage = " Username is blank";
				return false;
			}
			
			if(password == null || password.equals("")) {
				errorMessage = " Password is blank";
				return false;
			}
		
			if(username.length() > GlobalConstants.getDefaultUsernameMaxLength()) {
					errorMessage = " Username is too long";
					return false;
			}
		
			if(username.length() < GlobalConstants.getDefaultUsernameMinLength()) {
				errorMessage = " Username is too short";
				return false;
			}
			
			if(password.length() > GlobalConstants.getDefaultPasswordMaxLength()) {
				errorMessage = " Password is too long";
				return false;
			}
			
			if(password.length() < GlobalConstants.getDefaultPasswordMinLength()) {
				errorMessage = " Password is too short";
				return false;
			}
	
		
		try {	
				userRepo.addUser(username, password);	
			}
		catch(Exception e){
			errorMessage = " Database operation failed";
			return false;
		}
		return true;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
}
