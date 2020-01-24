package uni.fmi.cinemacity.repository;
import java.util.ArrayList;

import uni.fmi.cinemacity.model.User;
public class UserRepository {
	private ArrayList<User> users = new ArrayList<User>();
	
	public UserRepository() {
		users.add(new User("Ivan", "vankata69"));
		users.add(new User("Pesho", "peshoto69"));
		users.add(new User("Vasil", "vasilkata69"));
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
	
	public User getUserByID(int id) {
		return users.stream().filter(user -> user.getId() == id)
				.findFirst()
				.get();
	}
	
	public User getUserByUsername(String username) {
		return users.stream().filter(user -> user.getUsername() == username)
				.findFirst()
				.get();
	}
	
	public User getUserByUsernameAndPassword(String username, String password) {
		return users.stream().filter(user -> user.getUsername() == username 
				&& user.getPassword() == password)
				.findFirst()
				.get();
	}
	
	public boolean existsUserByUsernameAndPassword(String username,  String password) {
		return users.stream().anyMatch(user -> user.getUsername().equals(username)
				&& user.getPassword().equals(password));
	}


	public void addUser(User user) {
		users.add(user);
	}
	
	public void addUser(String username, String password) {
		users.add(new User(username, password));
	}
	
	public void removeUser(User user) {
		users.remove(user);
	}
	
	public void removeUserByID(int id) {
		users.removeIf(user -> user.getId() == id);
	}
	
	public void removeUserByUsername(String username) {
		users.removeIf(user -> user.getUsername().equals(username));
	}
	
	public void updateUser(User oldUser, User newUser) {
		users.remove(oldUser);
		users.add(newUser);
	}
}
