package uni.fmi.cinemacity.common;

import uni.fmi.cinemacity.model.Projection;
import uni.fmi.cinemacity.model.Reservation;
import uni.fmi.cinemacity.repository.ReservationRepository;

public class ReservationService {
	private ReservationRepository reservationRepo = new ReservationRepository();
	private String errorMessage;
	
	public ReservationService() {
	
	}
	
	public void reserve(Reservation reservation) {
		if(reservation.getProjection().getSeats() <= GlobalConstants.getDefaultMaxSeats()) {
			reservation.getProjection().incrementBlockedSeats(reservation.getChosenSeats());
			reservationRepo.addReservation(reservation);
		}
		else {
			errorMessage = " No vacant seats!";
		}
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
}
