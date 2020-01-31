package uni.fmi.ui;

import java.util.ArrayList;

import org.joda.time.DateTime;

import uni.fmi.cinemacity.common.GlobalConstants;
import uni.fmi.cinemacity.common.ReservationService;
import uni.fmi.cinemacity.model.Projection;
import uni.fmi.cinemacity.model.Reservation;

public class ReservationForm {
	private ReservationService reservationService = new ReservationService();
	
	// Temporary reservation during creation and form registration
	private Reservation reservation = new Reservation();
	
	public void chooseSeatsForProjection(ArrayList<Integer> seats) {
		reservation.setChosenSeats(seats);
	}
	
	public void chooseProjectionForReservation(Projection projection) {
		reservation.setProjection(projection);
	}
	
	public boolean isSeatChosen() {
		// For GUI (not unit tests) when we have one
		return !reservation.getChosenSeats().isEmpty();
	}

	public ReservationCheckoutForm clickToCheckoutButton() {
		return new ReservationCheckoutForm();
	}
	
	public void reserve(ReservationCheckoutForm checkoutForm) {
		if(checkoutForm.getCheckoutComplete()) {
			reservationService.reserve(reservation);
		}
		else {
			checkoutForm.setErrorMessage(GlobalConstants.getReservationFailedCheckoutEmptyString());
		}
	}
}
