package uni.fmi.cinemacity.model;

import java.util.*;

import org.joda.time.DateTime;

public class Projection extends BaseEntity {

	/**
	 * Default constructor
	 */
	public Projection() {

	}

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private Movie movie;

	/**
	 * 
	 */
	private DateTime startTime;

	/**
	 * 
	 */
	private DateTime endTime;

	/**
	 * 
	 */
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

}