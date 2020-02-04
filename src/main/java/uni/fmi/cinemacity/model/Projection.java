package uni.fmi.cinemacity.model;

import java.util.*;

import org.joda.time.DateTime;

import uni.fmi.cinemacity.common.GlobalConstants;

public class Projection extends BaseEntity {

	/**
	 * Default constructor
	 */
	public Projection() {

	}
	
	public Projection(String name, Movie movie, DateTime startTime, DateTime endTime) {
		this.name = name;
		this.movie = movie;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seats = GlobalConstants.getDefaultMaxSeats();
		
		blockedSeats.add(25);
		blockedSeats.add(26);
	}
	
	private String name;
	private Movie movie;
	private DateTime startTime;
	private DateTime endTime;
	private int seats;
	private ArrayList<Integer> blockedSeats = new ArrayList<Integer>();
	public Set<Reservation> reservations;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public int getSeats() {
		return seats;
	}

	public ArrayList<Integer> getBlockedSeats(){
		return blockedSeats;
	}
	
	public int getBlockedSeatsCount() {
		return blockedSeats.size();
	}
	
	public void setBlockedSeats(ArrayList<Integer> chosenSeats) {
		this.blockedSeats = chosenSeats;
	}
	
	public void incrementBlockedSeats(ArrayList<Integer> chosenSeats) {
		for	(int seat : chosenSeats) {
			this.blockedSeats.add(seat);
		}
	}
}