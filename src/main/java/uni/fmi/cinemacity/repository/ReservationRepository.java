package uni.fmi.cinemacity.repository;

import java.util.ArrayList;

import org.joda.time.DateTime;

import uni.fmi.cinemacity.model.Reservation;
import uni.fmi.cinemacity.model.Reservation;

public class ReservationRepository {
	private ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		
	public ReservationRepository() {
		
	}

	public ArrayList<Reservation> getSchedules(){
		return reservations;
	}
	
	public Reservation getReservationByID(int id) {
		return reservations.stream().filter(Reservation -> Reservation.getId() == id)
				.findFirst()
				.get();
	}
	
	public boolean existsReservationByDate(DateTime dateTime) {
		return reservations.stream().anyMatch(Reservation -> Reservation.getStartDate() == dateTime);
	}
	
	public void addReservation(Reservation Reservation) {
		reservations.add(Reservation);
	}
	
	public void addReservation(String name) {
		reservations.add(new Reservation());
	}
	
	public void removeSchedule(Reservation Reservation) {
		reservations.remove(Reservation);
	}
	
	public void removeScheduleByID(int id) {
		reservations.removeIf(Reservation -> Reservation.getId() == id);
	}
	
	public void updateSchedule(Reservation oldSchedule, Reservation newSchedule) {
		reservations.remove(oldSchedule);
		reservations.add(newSchedule);
	}
		
}
