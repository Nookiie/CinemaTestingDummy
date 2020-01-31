package uni.fmi.cinemacity.model;

import java.util.*;

import org.joda.time.DateTime;

public class Reservation extends BaseEntity {
	private User user;	
	private Projection projection;
	private DateTime startDate;
	private DateTime expireDate;
	private String name;
	private ArrayList<Integer> seats;

	public Reservation() {
		
	}
	public Reservation(User user, Projection projection, ArrayList<Integer> seats, ArrayList<Integer> rows) {
		this.user = user;
		this.projection = projection;
	}
	
	public Reservation(Projection projection, String name, ArrayList<Integer> seats, ArrayList<Integer> rows) {
		this.projection = projection;
		this.startDate = DateTime.now();
		this.expireDate = projection.getStartTime().withDurationAdded(-1, 1);
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

	public ArrayList<Integer> getChosenSeats() {
		return seats;
	}
	
	public void setChosenSeats(ArrayList<Integer> seats) {
		this.seats = seats;
	}

}