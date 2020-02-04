package uni.fmi.cinemacity.common;

import uni.fmi.cinemacity.model.Projection;
import uni.fmi.cinemacity.model.Reservation;
import uni.fmi.cinemacity.repository.ReservationRepository;

public class ReservationService {
	private ReservationRepository reservationRepo = new ReservationRepository();
	private String errorMessage = GlobalConstants.getReservationSuccessString();
	
	public ReservationService() {
		
	}
	
	public boolean checkReservationSeats(Reservation reservation) {
		if(reservation.getChosenSeats().isEmpty()) {
			errorMessage = GlobalConstants.getReservationFailedString() + " No selected seats!";
		}
		
		if(reservation.getProjection().getSeats() - 
				(reservation.getProjection().getBlockedSeatsCount() + reservation.getChosenSeats().size())  <= 0) {
			errorMessage = GlobalConstants.getReservationFailedString() + " No vacant seats!";
			return false;
		}
		
		for(int seat : reservation.getProjection().getBlockedSeats()) {
			for(int chosenSeat : reservation.getChosenSeats()) {
				if(seat == chosenSeat) {
					errorMessage = GlobalConstants.getReservationFailedString() + " Seat is reserved!";
					return false;
				}
			}
		}
		
		return true;
	}
	
	public void reserve(Reservation reservation) {
		if(checkReservationSeats(reservation)) {
			reservation.getProjection().incrementBlockedSeats(reservation.getChosenSeats());
			reservationRepo.addReservation(reservation);	
		}
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	
}
