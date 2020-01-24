package uni.fmi.cinemacity.model;

import java.util.*;

import org.joda.time.DateTime;

public class Reservation extends BaseEntity {
	private User user;
	private Projection projection;
	private DateTime startDate;
	private DateTime expireDate;
	public Set<User> users;

	public Reservation() {
		
	}
	public Reservation(User user, Projection projection) {
		this.user = user;
		this.projection = projection;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Projection getProjection() {
		return projection;
	}

	public void setProjection(Projection projection) {
		this.projection = projection;
	}

	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	public DateTime getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(DateTime expireDate) {
		this.expireDate = expireDate;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}