package uni.fmi.ui;

import org.joda.time.DateTime;

import uni.fmi.cinemacity.common.GlobalConstants;
import uni.fmi.cinemacity.common.ReservationService;
import uni.fmi.cinemacity.model.Projection;
import uni.fmi.cinemacity.model.Reservation;

public class ReservationForm {
	private ReservationService reservationService = new ReservationService();
	private Reservation reservation = new Reservation();
	
	public void chooseSeatsForProjection(int seats) {
		reservation.setChosenSeats(seats);
	}
	
	public void chooseProjectionForReservation(Projection projection) {
		reservation.setProjection(projection);
	}

	public ReservationCheckoutForm clickToCheckoutButton() {
		return new ReservationCheckoutForm();
	}
	
	public void reserve(ReservationCheckoutForm checkoutForm) {
		if(checkoutForm.getCheckoutComplete()) {
			reservationService.reserve(reservation);
		}
	}
}
